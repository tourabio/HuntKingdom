/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Animal;
import Services.AnimalService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author tibh
 */
public class AnimalsController implements Initializable {
@FXML
    private HBox hbox;
    @FXML
    private ScrollPane scrol;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AnimalService SA = new AnimalService();
            hbox.getChildren().clear();
               
            List<Animal> animals = SA.getAnimals();
            System.out.println(animals);
            afficher(animals);
       
            
    }   
    public void afficher(List<Animal> animals){
        for (int i = 0; i < animals.size(); i++) {
            //hbox.paddingProperty();
            
            Pane pane = new Pane();
            pane.setPrefWidth(200);
            pane.setPrefHeight(200);
            pane.setLayoutX(0);
            pane.setLayoutY(0);
           
            
            ImageView img = new ImageView(new Image("file:/C:/Users/tibh/Desktop/Pidev2020/copieJava/huntKingdom/src/Uploads/"+animals.get(i).getImage_animal()));
           
            img.setPreserveRatio(false);
            img.setLayoutX(0);
            img.setLayoutY(0); 
            img.setFitWidth(200);
            img.setFitHeight(173);

            pane.getChildren().add(img);
            
            Label lnom = new Label("Nom :");
            lnom.setLayoutX(14);
            lnom.setLayoutY(191);
            lnom.setPrefWidth(35);
            lnom.setPrefHeight(17);
            lnom.setTextFill(Color.WHITE);
            pane.getChildren().add(lnom);
            
            Label nom = new Label(animals.get(i).getNom());
            nom.setLayoutX(58);
            nom.setLayoutY(191);
            nom.setPrefWidth(98);
            nom.setPrefHeight(17);   
            nom.setTextFill(Color.WHITE);
            pane.getChildren().add(nom);

            Label fromto = new Label("From "+animals.get(i).getDebutSaison()+" to "+animals.get(i).getFinSaison());
            fromto.setLayoutX(16);
            fromto.setLayoutY(228);
            fromto.setPrefWidth(88);
            fromto.setPrefHeight(17);   
            fromto.setTextFill(Color.WHITE);
            
            pane.getChildren().add(fromto);

            Label des = new Label(animals.get(i).getDescription());
            des.setLayoutX(7);
            des.setLayoutY(262);
            des.setPrefWidth(182);
            des.setPrefHeight(129);   
            des.setWrapText(true);
            des.setTextFill(Color.WHITE);
            
            pane.getChildren().add(des);
            
            hbox.getChildren().add(pane);
            hbox.setStyle("-fx-background-color: transparent;");
            scrol.setStyle("-fx-background-color: transparent;");
            
            
        }    
    
    }
    
}
