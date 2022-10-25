public class WaffleGame {
  /**
 *ESte programa ilustra as funcionalidades do jogo Waffle
 *author goncalotorrao 59793
 *author eduardothomaz 
 */

    public static void main(String[] args) {
     int numero = 14638;
     int tamanhoNumero = nDigitos(numero);
     boolean bHasZeroDigit = false;

      System.out.println("O tamanho do numero é: " + tamanhoNumero);

      boolean numeroTamanhoValido = numeroValido(tamanhoNumero,numero);

      System.out.println("O numero e valido: " + numeroTamanhoValido);
   }
 
      private static int nDigitos(int numero) {
     
         int tamanho = 0;
         long valorFixo = 1;

         while (valorFixo <= numero) {
               tamanho++;
               valorFixo *= 10;
         }  
         return tamanho;
      }

      private static boolean numeroValido(int tamanhoNumero,int nr) {

         boolean bIsValidNumber = false;
      
         // Validar se o numero tem o tamanho correto
         if(tamanhoNumero == 3 || tamanhoNumero == 5 || tamanhoNumero == 7 || tamanhoNumero == 9) {
            bIsValidNumber = true;
         }
         else {
            bIsValidNumber = false;
         }
         
         //Validar que o numero tem de ser positivo
         if(nr>0 && bIsValidNumber) {
            bIsValidNumber = true;
         }
         else {
            bIsValidNumber = false;
         }
         
         //Validar se caso o numero tenha um digito 0 nao eh valido
         int valorFixo1 = nr;
         int valorFixo2=0;
         int lastNumber = 0;
         int firstNumber=0;
         boolean bLastNumberEqual = false;
         boolean bHasZeroChar = false;

         if(bIsValidNumber){
           for (int i = 1;i<=tamanhoNumero-1;i++){
               
               valorFixo2 = valorFixo1 %10;
               
               valorFixo1 = valorFixo1 / 10;

               System.out.println(valorFixo2);

               if(i>1){
                  if(lastNumber == valorFixo2) {
                     bLastNumberEqual = true;
                  }
                  else {
                     bLastNumberEqual = false;
                  }
               }
               else{
                  firstNumber = valorFixo2; 
                  lastNumber = valorFixo2; 
               }
               //Validar que o numero nao pode ter todos os digitos iguais
               if(firstNumber != valorFixo2 && !bLastNumberEqual){
                  lastNumber = valorFixo2; 
                  System.out.println("qqqq: " + valorFixo2 + ";" + lastNumber + ";" + firstNumber);
               }
               if(firstNumber == lastNumber) {
                  bIsValidNumber = false;
               }
               else{
                  bIsValidNumber = true;
               }
               if(valorFixo2 == 0)
                  bHasZeroChar = true;
                  System.out.println("O firstNumber e: " + firstNumber);
                  System.out.println("O lastNumber e : " + lastNumber);
                  
            }  
         } 
                  System.out.println("O zero e: " + bHasZeroChar);
                  System.out.println("O val e: " + bIsValidNumber);

         if(bHasZeroChar){
            bIsValidNumber = false;
         }
         return bIsValidNumber;
      }

      
}
