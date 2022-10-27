/**
 *ESte programa ilustra as funcionalidades do jogo Waffle
 *author goncalotorrao 59793
 *author eduardothomaz 
 */
public class WaffleGame11 {

    public static void main(String[] args) {
   
    int num= 13859;
    boolean bC1 = false;
    boolean bC2 = false;
    boolean bC3 = false;
    boolean bC4 = false;
    int tamanhoNumero = nDigitos(num); 
    boolean numPuzzleValido = false;
    
    
    bC1 = condicaoC1(num);

    if(bC1){
        // Caso a primeira valicao esteja correta passa
        bC2 = condicaoC2(tamanhoNumero);

        if(bC2){
            bC3 = condicaoC3(num,tamanhoNumero);

            if(bC3){
                bC4 = condicaoC4(num,tamanhoNumero);

                if(bC4){
                    numPuzzleValido = true;
                }
            }
        }
    }


    System.out.println("O numero tem " +tamanhoNumero+ " digitos");
    
    System.out.println("O numero eh valido " +numPuzzleValido);
    
    }


    public static int nDigitos(int num) {
     
        int tamanho = 0;
        long valorFixo = 1;

        while (valorFixo <= num) {
            tamanho++;
            valorFixo *= 10;
        }  
        return tamanho;
    }

        public static boolean condicaoC1(int num) {
        boolean c1= false;   
        if(num>0) {
            c1= true;
        }
        else if(num<0) {
            c1= false;
        }
        System.out.println("c1 " +c1);
        return c1;
        }
        public static boolean condicaoC2(int tamanhoNumero) {
        boolean c2=false;
        if(tamanhoNumero == 3 || tamanhoNumero == 5 || tamanhoNumero == 7 || tamanhoNumero == 9) {
            c2= true;
        }
        else {
            c2= false;
        }   
        System.out.println("c2 " +c2);
        return c2;
        }   
        
        public static boolean condicaoC3(int num,int tamanhoNumero) {
       
        boolean c3= false;
        int valorFixo1 = num;
        int valorFixo2=0;
        int lastNumber = 0;
        int firstNumber=0;
        boolean bLastNumberEqual = false;
        boolean bHasZeroChar = false;

        for (int i = 1;i<=tamanhoNumero-1;i++){
            
            valorFixo2 = valorFixo1 %10;
            
            valorFixo1 = valorFixo1 / 10;

            System.out.println(valorFixo2);

            if(i>1){
                if(lastNumber == valorFixo2) {
                    c3= true;
                }                               
                else {
                    c3= false;
                }
            }
            else{
                firstNumber = valorFixo2; 
                lastNumber = valorFixo2; 
            }
        }
         
               
        if(firstNumber != valorFixo2 && !bLastNumberEqual){
                  lastNumber = valorFixo2; 
                  System.out.println("qqqq: " + valorFixo2 + ";" + lastNumber + ";" + firstNumber);
               }
               if(firstNumber == lastNumber) {
                  c3= false;
               } 
               else{
                  c3= true;
               }
             System.out.println("c3" +c3);  
             return c3;
        }
        
        public static boolean condicaoC4(int num, int tamanhoNumero) {
        boolean c4= true;
        
         int digitoAtual=0;
         int numero = num;
         boolean bHasDigitZero = false;

        for(int i = 1;i<=tamanhoNumero-1;i++){
            digitoAtual = numero %10;
            numero = numero / 10;
               
            if(digitoAtual == 0) {
                bHasDigitZero = true;
            }
        }  

            if(bHasDigitZero)
                c4 = false;

            System.out.println("c4 " +c4);
            return c4;
        }
        
        public static boolean numeroValido(boolean c1, boolean c2, boolean c3, boolean c4) {
        boolean numValido= false;

        if(c1 && c2 && c3 && c4) {
            numValido= true;
        }
        else {
        numValido= false;
        }
        return numValido;
    }
    
    
}
