package principal;

import java.util.ArrayList;
import java.util.Scanner;


public class Notas {

   
    public static void main(String[] args) {
        ArrayList<Double> notas=new ArrayList<>();
        //en el array al crearlo está lleno de 0, no se ha guardado ninguna nota
        Scanner sc=new Scanner(System.in);
        int op;//opcion elegida
        
        do{
           mostrarMenu();
           op=Integer.parseInt(sc.nextLine()); //leer texto
           switch(op){
               case 1:
                   leerNota(notas,sc);
                   break;
               case 2:
                   double res=calcularMedia(notas);
                   System.out.println("Media: "+res);
                   break;
               case 3:
                  int aprob=calcularAprobados(notas);
                   System.out.println("Aprobados: "+aprob);
                   break;
               case 4:
                   verNotas(notas);
                   break;
               case 5:
                   modificarNotas(notas,sc);
                   break;
               case 6:
                   break;
               default:
                   System.out.println("Debes introducir una opción válida");
           }
        }while(op!=6);
    }
    
    public static void mostrarMenu(){
        System.out.println("1.- Añadir nota");
        System.out.println("2.- Media");
        System.out.println("3.- Aprobados");
        System.out.println("4.- Ver notas");
        System.out.println("5.- Modificar nota");
        System.out.println("6.- Salir");
    }
    
    public static void leerNota(ArrayList<Double> valores, Scanner sc){
            System.out.println("Nota:");
            double d=Double.parseDouble(sc.nextLine());
            valores.add(d);                  
    }
    
    public static double calcularMedia(ArrayList<Double> valores){
        double media=0;
        for(int i=0;i<valores.size();i++){ //lo recorre hasta las notas introducidas
            media+=valores.get(i);
        }
        media=media/valores.size();
        return media;
    }
    
    public static int calcularAprobados(ArrayList<Double> valores){
        int ap=0;
        for(Double n:valores){
            if(n>=5){
                ap++;
            }
        }
        return ap;
    } 
    
    public static void verNotas(ArrayList<Double> valores){
        for(int i=0;i<valores.size();i++){
            System.out.println(valores.get(i));
        }
    }
    
    public static void modificarNotas(ArrayList<Double> valores,Scanner sc){
        int pos;
        double NuevaNota;
        System.out.println("Introduce posición (la primera es 0): ");
        pos=Integer.parseInt(sc.nextLine());
        System.out.println("Introduce nueva nota: ");
        NuevaNota=Double.parseDouble(sc.nextLine());
        //sustituímos por la nueva
        valores.set(pos,NuevaNota);        
    }
}

