/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Technique;

/**
 *
 * @author ayach
 */

import java.util.ArrayList;
import java.util.List;

public class GestionTechnique implements Controle{
    
     private List <ServiceTechnique> services;

    public GestionTechnique() {
        this.services = new ArrayList<>();
    }

    public void ajouterService(ServiceTechnique service) {
        services.add(service);
    }

    public List <ServiceTechnique> getServices() {
        return services;
    }

    @Override
    public void effectuerControle() {
        System.out.println("Effectuer le contrôle de tous les services techniques.");
        for (ServiceTechnique service : services) {
            System.out.println("Contrôle du service : " + service.getNomDuService());
        }
    }
}


