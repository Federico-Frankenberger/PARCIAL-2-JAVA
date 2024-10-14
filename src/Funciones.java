import java.util.Calendar;
public class Funciones {
    public static boolean verificar(Computadora computadora,String texto, int contador) {
        String [][] matriz = computadora.getComponentes();
        for (int i = 0; i < contador; i++) {
            String auxiliar = matriz[i][0];
            if (auxiliar.equals(texto)) {
                return true;
            }
        }
        return false;
    }
    public static double verificarObligatorios(Computadora computadora,int contador) {
        String [][] matriz = computadora.getComponentes();
        int suma = 0;
        double recargo=0;
        for (int i = 0; i < contador; i++) {
            String auxiliar = matriz[i][3];
            if (auxiliar.equals("S")) {
                suma++;
            }
        }
        if (suma < 5) {
            System.out.println("Atención, 1 o más de los componentes obligatorios no fueron agregados, por este motivo se cobrara un recargo del 20%");
            recargo = 1.20;
        }
        return recargo;
    }
    public static double precioTotal(Computadora computadora, int contador) {
        String [][] matriz = computadora.getComponentes();
        int suma = 0;
        for (int i = 0; i < contador; i++) {
            suma += Integer.valueOf(matriz[i][2]);
        }
        return suma;
    }
    public static double montoFinal(double recargo,double suma) {
        if (recargo==0){
            return suma;
        }else {
            double montoFinal = (suma * recargo);
            return montoFinal;
        }

    }
    public static void mensaje(Computadora computadora,int contador ){
        String [][] matriz = computadora.getComponentes();
        Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        System.out.println("La computadora especificada es:");
        System.out.println("Marca: "+"\t"+computadora.getMarca());
        System.out.println("Modelo: "+"\t"+computadora.getModelo());
        System.out.println("Código de Barras: "+"\t"+computadora.getCodigoBarras());
        System.out.println("AÑo: "+"\t"+ano);
        System.out.println("Código Ítem " +"\t" + "Denominación " +"\t" +"Precio");
        for(int i=0;i<contador;i++){
            System.out.println(" "+"\t");
            for(int j=0;j<3;j++){
                System.out.print(matriz[i][j]+"\t"+"\t"+"\t");
            }
        }
        System.out.println();
        System.out.println(" "+"\t"+"\t"+"\t"+ "Total Componentes: " +"\t"+computadora.getPrecioTotal());
        System.out.println(" "+"\t"+"\t"+"\t"+ "Recargo: " +"\t"+(computadora.getMontoFinal() - computadora.getPrecioTotal()));
        System.out.println(" "+"\t"+"\t"+"\t"+ "Montofinal: " +"\t"+computadora.getMontoFinal());

    }
}