package com.comarch.camp.it.rent.car;

import com.comarch.camp.it.rent.car.authenticate.Authenticator;
import com.comarch.camp.it.rent.car.db.VehicleRepository;
import com.comarch.camp.it.rent.car.gui.GUI;
import com.comarch.camp.it.rent.car.model.User;

public class App {
    public static void main(String[] args) {
        final VehicleRepository baza = new VehicleRepository();
        final Authenticator authenticator = new Authenticator();
        boolean run = false;
        for(int i = 0; i < 3; i++) {
            User user = GUI.readLoginData();
            boolean authResult = authenticator.authenticate(user.getLogin(), user.getPassword());
            if(authResult) {
                System.out.println("Logged !!");
                run = true;
                break;
            }
            System.out.println("Incorrect login data !!");
        }
        while(run) {
            switch(GUI.showMenuAndReadChoose()) {
                case "1":
                    GUI.printVehicles(baza.getVehicles());
                    break;
                case "2":
                    GUI.showResult(baza.rentVehicle(GUI.readPlate()));
                    break;
                case "3":
                    GUI.showResult(baza.returnVehicle(GUI.readPlate()));
                    break;
                case "4":
                    run = false;
                    break;
                default:
                    GUI.showWrongChoose();
                    break;
            }
        }
    }
}
