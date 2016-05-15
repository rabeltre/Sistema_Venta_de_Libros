/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class Fecha {
    private static Fecha ourInstance = new Fecha();

    public static Fecha getInstance() {
        return ourInstance;
    }
 private int DiaY;
    private int MesY;
    private int YearY;
     private int DiaX;
    private int MesX;
    private int YearX;
    public Fecha() {
    }
    private boolean IsFechaCorrecta(){
        if(YearX>YearY){
            return false;
        }
        else if(MesX>MesY){
            return false;
        }
        else if(DiaX>DiaY){
            return false;
        }
        return true;
    }   
    public boolean isFechaCorrecta(Calendar fechaInicio, Calendar fechaFinal){
       
   
     Calendar cal; 
             cal= fechaInicio;
       DiaX=cal.get(Calendar.DAY_OF_MONTH);
        MesX=cal.get(Calendar.MONTH);
        YearX= cal.get(Calendar.YEAR)-1900;
        cal= fechaFinal;
        DiaY= cal.get(Calendar.DAY_OF_MONTH);
        MesY= cal.get(Calendar.MONTH);
        YearY= cal.get(Calendar.YEAR)-1900;
        int f =YearX + MesX + DiaX;
        if(IsFechaCorrecta()){
            if (YearX <0 || YearY < 0  ) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Seleccione una Fecha Correcta!");
                RequestContext.getCurrentInstance().showMessageInDialog(message);
           } else {
       
       return true;
            }
            }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Seleccione una Fecha Correcta!");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            }

  return false;
    }
    
    
    
}
