package com.moda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            
            Atelie a1 = new Atelie("Maison Aurore", "м. Київ, вул. Стильна, 3", "380449910901", "12");
            Atelie a2 = new Atelie("Atelier Nova", "м. Київ, просп. Моди, 8", "380449910902", "7");
            Atelie a3 = new Atelie("KUTURE by Melnyk", "м. Київ, вул. Подіумна, 11", "380449910903", "15");
            Atelie a4 = new Atelie("Studio Vogue", "м. Львів, вул. Галицька, 10", "380329910904", "9");
            Atelie a5 = new Atelie("Trend Atelier", "м. Одеса, вул. Морська, 21", "380489910905", "5");


            Pokupets p1 = new Pokupets("Катерина Лисенко", "Gold", "380501234567");
            Pokupets p2 = new Pokupets("Артем Коваль", "Silver", "380631234567");
            Pokupets p3 = new Pokupets("Олена Марченко", "Platinum", "380671112233");
            Pokupets p4 = new Pokupets("Дмитро Шевченко", "Standard", "380931112233");
            Pokupets p5 = new Pokupets("Ірина Савчук", "Gold", "380991122334");


            Odiah o1 = new Odiah("Сукня Luna", "груди:90; ", "талія:70; ", "бедра:95; ");
            Odiah o2 = new Odiah("Костюм Noir", "груди:98; ", "талія:84; ", null);
            Odiah o3 = new Odiah("Блуза Azure", "груди:88; ", "талія:72; ", null);
            Odiah o4 = new Odiah("Пальто Élite", "груди:86; ", "талія:68; ", null);
            Odiah o5 = new Odiah("Сорочка Sky", "груди:90; ", "талія:70; ", null);
            Odiah o6 = new Odiah("Пальто Terra", "груди:98; ", "талія:84; ", null);


            Tkanina t1 = new Tkanina("шовк");
            Tkanina t2 = new Tkanina("мереживо");
            Tkanina t3 = new Tkanina("бавовна");
            Tkanina t4 = new Tkanina("льон");
            Tkanina t5 = new Tkanina("вовна");
            Tkanina t6 = new Tkanina("віскоза");
            Tkanina t7 = new Tkanina("кашемір");
            Tkanina t8 = new Tkanina("атлас");


            o1.getTkaniny().add(t1); 
            o1.getTkaniny().add(t2); 
            o2.getTkaniny().add(t5); 
            o2.getTkaniny().add(t6); 
            o3.getTkaniny().add(t3); 
            o4.getTkaniny().add(t7); 
            o5.getTkaniny().add(t3); 
            o6.getTkaniny().add(t1); 


            session.persist(a1); session.persist(a2); session.persist(a3); session.persist(a4); session.persist(a5);
            session.persist(p1); session.persist(p2); session.persist(p3); session.persist(p4); session.persist(p5);
            session.persist(o1); session.persist(o2); session.persist(o3); session.persist(o4); session.persist(o5); session.persist(o6);

            session.persist(t1); session.persist(t2); session.persist(t3); session.persist(t4); session.persist(t5);
            session.persist(t6); session.persist(t7); session.persist(t8);


            session.persist(new Primirka("2024-09-14", a1, o1, p1));
            session.persist(new Primirka("2024-09-14", a1, o2, p2)); 
            session.persist(new Primirka("2024-09-15", a2, o2, p2));
            session.persist(new Primirka("2024-09-15", a2, o5, p4));
            session.persist(new Primirka("2024-09-16", a3, o1, p1));
            session.persist(new Primirka("2024-09-16", a3, o6, p2));
            session.persist(new Primirka("2024-09-17", a1, o4, p3));
            session.persist(new Primirka("2024-09-18", a2, o5, p4));
            session.persist(new Primirka("2024-09-19", a4, o4, p5));
            session.persist(new Primirka("2024-09-20", a5, o5, p5));
            session.persist(new Primirka("2024-09-22", a1, o6, p3));

            tx.commit();


            session = factory.openSession();
            tx = session.beginTransaction();

            List<ModalInfoDTO> result = session.createQuery(
                "SELECT new com.moda.ModalInfoDTO(" +
                        "p.pib, " +                       
                        "a.nazva, " +                     
                        "pr.dataPrimirky, " +             
                        "o.model, " +                     
                        "concat(coalesce(o.grudy,''), coalesce(o.talia,''), coalesce(o.bedra,'')), " + 
                        "t.nazva, " +                     
                        "p.rivenKlienta, " +              
                        "a.stazhKutyrie, " +             
                        "a.adres, " +                     
                        "a.telefon) " +                  
                "FROM Primirka pr " +
                "JOIN pr.pokupets p " +
                "JOIN pr.atelie a " +
                "JOIN pr.odiah o " +
                "JOIN o.tkaniny t",
                ModalInfoDTO.class
            ).list();

            System.out.println("Денормалізована таблиця Мода (отримана через HQL):");
            System.out.println("\tПокупець | Кутюрʼє | Дата примірки | Модель виробу | Розміри | Тканини | Рівень клієнта | Стаж кутюрʼє | Ательє адреса | Телефон ательє\r\n");
            result.forEach(System.out::println);


            String create = "CREATE TABLE IF NOT EXISTS denormalized (" +
                    "pokupets varchar, kuturie varchar, data_primirky varchar, model_vyrobu varchar, " +
                    "rozmiry varchar, tkanini varchar, riven_klienta varchar, stazh_kutyrie varchar, " +
                    "adres_atelie varchar, telefon_atelie varchar" +
                    ")";
            session.createNativeQuery(create).executeUpdate();


            session.createNativeQuery("TRUNCATE TABLE denormalized").executeUpdate();


            for (ModalInfoDTO dto : result) {
                session.createNativeQuery(
                        "INSERT INTO denormalized(pokupets, kuturie, data_primirky, model_vyrobu, rozmiry, tkanini, riven_klienta, stazh_kutyrie, adres_atelie, telefon_atelie) " +
                                "VALUES(:pok, :kut, :dat, :mod, :roz, :tk, :riv, :st, :adr, :tel)")
                        .setParameter("pok", dto.getPokupets())
                        .setParameter("kut", dto.getKuturie())
                        .setParameter("dat", dto.getData_primirky())
                        .setParameter("mod", dto.getModel_vyrobu())
                        .setParameter("roz", dto.getRozmiry())
                        .setParameter("tk", dto.getTkanini())
                        .setParameter("riv", dto.getRiven_klienta())
                        .setParameter("st", dto.getStazh_kutyrie())
                        .setParameter("adr", dto.getAdres())
                        .setParameter("tel", dto.getTelefon())
                        .executeUpdate();
            }

            List<Object[]> den = session.createNativeQuery("SELECT pokupets, kuturie, data_primirky, model_vyrobu, rozmiry, tkanini, riven_klienta, stazh_kutyrie, adres_atelie, telefon_atelie FROM denormalized").list();

            System.out.println("\n\tТаблиця Мода:");
            System.out.println("\tПокупець | Кутюрʼє | Дата примірки | Модель виробу | Розміри | Тканини | Рівень клієнта | Стаж кутюрʼє | Ательє адреса | Телефон ательє\r\n" + //
                                "");
            for (Object[] row : den) {
                System.out.printf("%s | %s | %s | %s | %s | %s | %s | %s | %s | %s%n",
                        row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
            if (factory != null && !factory.isClosed()) factory.close();
        }
    }
}