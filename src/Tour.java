

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Tour  implements java.io.Serializable {



    private final String name;
    private final double price;
    private final float durationOfTour;
    private int quantityOfBookings;
    private final String languageOfTour;
    private TourSpec tourSpec;

    public Tour(String name, double price,
                     float durationOfTour,
                     int quantityOfBookings,
                     String languageOfTour, TourSpec tourSpec ) {
        this.name = name;
        this.price = price;
        this.durationOfTour = durationOfTour;
        this.quantityOfBookings = quantityOfBookings;
        this.languageOfTour = languageOfTour;
        this.tourSpec = tourSpec;
    }
    public Tour(String name, double price,
                float durationOfTour,
                int quantityOfBookings,
                String languageOfTour, boolean isMostPopular, TypeOfTour typeOfTour) {
        this.name = name;
        this.price = price;
        this.durationOfTour = durationOfTour;
        this.quantityOfBookings = quantityOfBookings;
        this.languageOfTour = languageOfTour;
        this.tourSpec = new TourSpec(isMostPopular, typeOfTour);
    }
    public Tour() {
        this.name = "";
        this.price = 0;
        this.durationOfTour = 0;
        this.quantityOfBookings = 0;
        this.languageOfTour = "";
        this.tourSpec = new TourSpec();
    }
    public void messageTo(FileOutputStream fileOut) {
        try(ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }






    public String getName (){
        return name;
    }

    public double getPrice () {
        return price;
    }

    public float getDurationOfTour  () {
        return durationOfTour;
    }



    public int getQuantityOfBookings() {
        return quantityOfBookings;
    }

    public String getLanguageOfTour() {
        return languageOfTour;
    }
    public TourSpec getTourSpec() {
        return  tourSpec;
    }




    public String toString() {
        return "Name: " + getName() + "\n" +
                "Price: " + getPrice() + " euro" + "\n" +
                "Duration of Tour: " + getDurationOfTour() + " hour" + "\n" +
                "Quantity of bookings: " + getQuantityOfBookings() +  "\n" +
                "Language of Tour: " + getLanguageOfTour() +"\n"  +
                "The most popular tour: " + getTourSpec().isMostPopular() + "\n" +
                "Type of tour: " + getTourSpec().getTypeOfTour().toString() +"\n";
    }

}

