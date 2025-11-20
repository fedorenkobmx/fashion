package com.fashion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fashion-collection")
public class Fashion {

    @Id
    private String id;

    private String customer;
    private String couturier;
    private String fitting_date;
    private String item_model;
    private String sizes;
    private String fabrics;
    private String customer_level;
    private int couturier_experience;
    private String atelier_address;
    private long atelier_phone;

    public Fashion(String customer, String couturier, String fitting_date, String item_model,
                   String sizes, String fabrics, String customer_level, int couturier_experience,
                   String atelier_address, long atelier_phone) {

        this.customer = customer;
        this.couturier = couturier;
        this.fitting_date = fitting_date;
        this.item_model = item_model;
        this.sizes = sizes;
        this.fabrics = fabrics;
        this.customer_level = customer_level;
        this.couturier_experience = couturier_experience;
        this.atelier_address = atelier_address;
        this.atelier_phone = atelier_phone;
    }

    @Override
    public String toString() {
        return "Fashion {" +
                "\n  id=\"" + id + "\"" +
                "\n  customer=\"" + customer + "\"" +
                "\n  couturier=\"" + couturier + "\"" +
                "\n  fitting_date=\"" + fitting_date + "\"" +
                "\n  item_model=\"" + item_model + "\"" +
                "\n  sizes=\"" + sizes + "\"" +
                "\n  fabrics=\"" + fabrics + "\"" +
                "\n  customer_level=\"" + customer_level + "\"" +
                "\n  couturier_experience=\"" + couturier_experience + "\"" +
                "\n  atelier_address=\"" + atelier_address + "\"" +
                "\n  atelier_phone=\"" + atelier_phone + "\"" +
                "\n}";
    }
}
