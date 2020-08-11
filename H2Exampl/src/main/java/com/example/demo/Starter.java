package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Starter {

       public static void main(String[] args) {
               List<Color> colors = initColors();
               // just print the color names
               colors.stream().forEach(color -> System.out.println(color.getName()));
               List<Car> cars = new ArrayList<>();
               initCars(cars);
               // just print the car names
               cars.stream().map(car -> car.getName()).forEach(System.out::println);
               // next, join color name to car and print carName: colorName
               // sample 1: access to collection
		/*
		 * cars.stream() .map(car -> car.getName() + ": " + colors
		 * .get(car.getColorId()) .getName()) .forEach(System.out::println);
		 */
               // sample 2: "joining" streams
               List<Result> x = cars.stream()
                               .map(car -> {   Result result   = new Result() ;
                               result.setCar(car);
							result.setColor(colors
                                    .stream()
                                    .filter(color -> color.getId() == car.getColorId())
                                    .findAny().get());
                               return result;
                                               }).collect(Collectors.toList());

     for (Result r:x)
     {
    	 System.out.println(r.getCar().getName());
     }
       }

       private static void initCars(List<Car> cars) {
               cars.add(new Car("VW", 1));
               cars.add(new Car("Ford", 2));
               cars.add(new Car("Chevrolet", 1));
               cars.add(new Car("BMW", 3));
               cars.add(new Car("Ferrari", 1));
               cars.add(new Car("Mercedes", 2));
               cars.add(new Car("Mercedes", 3));
       }

       private static List<Color> initColors() {
               List<Color> colors = new ArrayList<>();
               colors.add(new Color(0, "unknown"));
               colors.add(new Color(1, "red"));
               colors.add(new Color(2, "green"));
               colors.add(new Color(3, "blue"));
               return colors;
       }
}
