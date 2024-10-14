import java.util.Scanner;

public class GeneraPC {

    public static void main(String[] args) {
        String [][] componentesPc = {{"AAA","Placa Madre", "20000", "S"} , {"BBB","Procesador" , "25000" , "S"} , {"CCC","Memoria RAM", "5000" , "S"} , {"DDD","Placa de Red", "3000" , "N"} , {"EEE","Disco Rigido SSD", "22000" , "S"} , {"FFF"," Placa de Video", "42000" , "N"} , {"GGG", "Monitor Led 21", "32000" , "N"} , {"HHH","Monitor Led 25", "41000" , "N"} , {"JJJ","Kit Teclado - Mouse", "9000" , "N"} , {"KKK","Gabinete", "6500" , "S"}, {"LLL","Fuente Alimentación", "6500" , "S"}, {"MMM","Placa de Sonido", "16500" , "N"}};
        Scanner sc = new Scanner(System.in);
        Computadora computadora = new Computadora();
        System.out.println("Ingrese la Marca:");
        String marca = sc.nextLine();
        computadora.setMarca(marca);
        System.out.println("Ingrese el Modelo:");
        String modelo = sc.nextLine();
        computadora.setModelo(modelo);
        long codigoBarras;
        int largoCodigo;

        do {
            System.out.println("Ingrese el Código de Barras:");
            codigoBarras = sc.nextLong();
            largoCodigo = (int) String.valueOf(codigoBarras).length();
            if (largoCodigo < 7||largoCodigo>15){
                System.out.println("El codigo del Barras no es valido");
            }
        } while (largoCodigo < 7||largoCodigo>15);

        computadora.setCodigoBarras(codigoBarras);

        int cantidadComponentes;

        do {
            System.out.println("Ingrese la cantidad de componentes que tendra la PC:");
            cantidadComponentes = sc.nextInt();
            sc.nextLine();
            if (cantidadComponentes < 5||cantidadComponentes > 12){
                System.out.println("El cantidad del componente no es valido");
            }
        }while (cantidadComponentes < 5||cantidadComponentes > 12);

        computadora.setComponentes(cantidadComponentes, 4);

        int contador = 0;
        System.out.println("Componentes de la Computadora");
        do {
            System.out.println("Ingrese el código del componente " +(contador+1)+" :");
            String codigoComponente = sc.nextLine();
            String comp;
            int contador2 = 0;
            if (contador==0){
                for (int j = 0; j < componentesPc.length; j++) {
                    comp = componentesPc[j][0];
                    if (comp.equals(codigoComponente)){
                        for(int k = 0; k < 4; k++){
                            String valor = componentesPc[j][k];
                            computadora.setComponente(contador,k,valor);
                        }
                        contador ++;
                        contador2++;
                    }
                }
                if (contador2==0){
                    System.out.println("El codigo del componente no es valido");
                }
            }else {
                Funciones funcion = new Funciones();
                boolean respuesta = funcion.verificar(computadora,codigoComponente,contador);
                if (respuesta==false){
                    for (int j = 0; j < componentesPc.length; j++) {
                        comp = componentesPc[j][0];
                        if (comp.equals(codigoComponente)){
                            for(int k = 0; k < 4; k++){
                                String valor = componentesPc[j][k];
                                computadora.setComponente(contador,k,valor);
                            }
                            contador ++;
                            contador2++;
                        }
                    }
                    if (contador2==0){
                        System.out.println("El codigo del componente no es valido");
                    }
                }else {
                    System.out.println("El componente ya fue agregado anteriormente");
                }
            }

        }while (cantidadComponentes != contador);
        computadora.setPrecioTotal(Funciones.precioTotal(computadora,contador));
        computadora.setPorcentajeAumento(Funciones.verificarObligatorios(computadora,contador));
        computadora.setMontoFinal(Funciones.montoFinal(computadora.getPorcentajeAumento(),computadora.getPrecioTotal()));
        Funciones.mensaje(computadora,contador);


    }
}


/*String [][] perro = computadora.getComponentes();
                for (int j = 0; j < contador; j++) {
        System.out.println();
                    for (int k = 0; k < 4; k++) {
        System.out.print(perro[j][k]+"\t");
                    }
                            }*/