/**
 *Este programa ilustra as funcionalidades do jogo Waffle
 *author goncalotorrao 59793
 *author eduardothomaz 59799
 *Compilar javac WaffleGame1.java
 *Executar java WaffleGame1
 */
public class WaffleGame1 {
 
    public static void main(String[] args) {
   
    int num= 4528123;
    int jesimoNum=3;
    int iPosition=6;
    int jPosition=4;
    boolean bC1 = false;
    boolean bC2 = false;
    boolean bC3 = false;
    boolean bC4 = false;
    int tamanhoNumero = nDigitos(num); 
    boolean numPuzzleValido = false;

     bC1 = condicaoC1(num);
     if(bC1){
        // Caso a primeira condicao esteja correta passa para c2
        bC2 = condicaoC2(num,tamanhoNumero);

        if(bC2){
            // Caso a segunda condicao esteja correta para para c3
            bC3 = condicaoC3(num,tamanhoNumero);

            if(bC3){
                // Caso a terceira condicao esteja correta para para c4
                bC4 = condicaoC4(num,tamanhoNumero);

                if(bC4){
                    // Caso a quarta condicao esteja correta o numero eh valido retornando o jesimo digito e trocando o i com o j
                    numPuzzleValido = true;
                    jnesimoElemento(num,jesimoNum,tamanhoNumero); 
                    swapDigitiDigitJ(num,iPosition,jPosition,tamanhoNumero);
                }
            }
        }
     }
    // Caso o numero seja valido imprime a validacao do numero
    if(numPuzzleValido) {
      System.out.println("The puzzle " +num+ " is valid."); 
        swapLastDigits(num, numPuzzleValido);
        swapFirstDigits(num, tamanhoNumero, numPuzzleValido); 
    }
}

    /**
    *Funcao que devolve o numero de digitos do puzzle
    *
    *@param num o puzzle
    *@requires {@code valorFixo <= num}
    *@ensures {@code \result>0}
    *@return o numero de digitos do puzzle
    */
    public static int nDigitos(int num) {
     
        int tamanho = 0;
        long valorFixo = 1;

        while (valorFixo <= num) {
            tamanho++;
            valorFixo *= 10;
        }  
        return tamanho;
    }

        /**
        *Funcao para validar a primeira condicao
        *
        *@param num o puzzle
        *@requires {@code num>0}
        *@ensures {@code \result>0}
        *@return se o numero eh positivo ou negativo
        */
        public static boolean condicaoC1(int num) {
        boolean c1= false;   
        if(num>0) {
            c1= true;
        }
        else if(num<0) {
            c1= false;
            System.out.println("The puzzle " +num+ " is invalid: it does not verify condition C1.");
        }
        return c1;
        }
        
        
        /**
        *Funcao para validar a segunda condicao
        *
        *@param num o puzzle
        *@param tamanhoNumero o numero de digitos do puzzle
        *@requires {@code tamanhoNumero == 3 || tamanhoNumero == 5 || tamanhoNumero == 7 || tamanhoNumero == 9}
        *@ensures {@code \result>0}
        *@return se o numero tem um numero de digitos correto
        */
        public static boolean condicaoC2(int num, int tamanhoNumero) {
        
        boolean c2=false;
        if(tamanhoNumero == 3 || tamanhoNumero == 5 || tamanhoNumero == 7 || tamanhoNumero == 9) {
            c2= true;
        }
        else {
            c2= false;
            System.out.println("The puzzle " +num+ " is invalid: it does not verify condition C2.");
        }   
        return c2;
        }   
        
        /**
        *Funcao para validar a terceira condicao
        *
        *@param num o puzzle
        *@param tamanhoNumero o numero de digitos do puzzle
        *@requires {@code i<=tamanhoNumero && digitoAtual==0}
        *@ensures {@code \result>0}
        *@return se o numero tem um digito 0
        */
        public static boolean condicaoC3(int num,int tamanhoNumero) {
       
        boolean c3= true;
        int digitoAtual=0;
        int numero = num;
        boolean bHasDigitZero = false;

        for(int i = 1;i<=tamanhoNumero-1;i++){
            digitoAtual = numero %10;
            numero = numero / 10;
               
            if(digitoAtual == 0) {
                bHasDigitZero = true;
                System.out.println("The puzzle " +num+ " is invalid: it does not verify condition C3.");
            }
        }  
            if(bHasDigitZero) {
                c3 = false;
            }
            return c3;
        }
        
        /**
        *Funcao para validar a quarta condicao
        *
        *@param num o puzzle
        *@param tamanhoNumero o numero de digitos do puzzle
        *@requires {@code i<=tamanhoNumero && lastNumber == valorFixo2}
        *@ensures {@code \result>0}
        *@return se o numero tem ou nao os digitos todos iguais
        */
        public static boolean condicaoC4(int num, int tamanhoNumero) {
        
        boolean c4= false;
        int valorFixo1 = num;
        int valorFixo2=0;
        int lastNumber = 0;
        int firstNumber=0;
        boolean bLastNumberEqual = false;
        boolean bHasZeroChar = false;

        for (int i = 1;i<=tamanhoNumero;i++){
            
            valorFixo2 = valorFixo1 %10;
            valorFixo1 = valorFixo1 / 10;

            if(i>1){
                if(lastNumber == valorFixo2) {
                    c4= true;
                }                               
                else {
                    c4= false;
                }
            }
            else{
                firstNumber = valorFixo2; 
                lastNumber = valorFixo2; 
            }
        }
         
         if(firstNumber != valorFixo2 && !bLastNumberEqual){
                  lastNumber = valorFixo2; 
               }
               if(firstNumber == lastNumber) {
                  c4= false;
                    System.out.println("The puzzle " +num+ " is invalid: it does not verify condition C4.");               } 
               else{
                  c4= true;
               }  
                return c4;
            }
        
        /**
        *Funcao que valida se o puzzle eh valido ou invalido
        *
        *@param c1 primeira condicao
        *@param c2 segunda condicao
        *@param c3 terceira condicao
        *@param c4 quarta condicao 
        *@requires {@code c1 && c2 && c3 && c4}
        *@ensures {@code \result>0}
        *@return se o numero eh valido
        */
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

        /**
        *Funcao que retorna o jesimo digito do puzzle a contar da esquerda
        *
        *@param num o puzzle
        *@param j numero inteiro j
        *@param tamanhoNumero numero de digitos do puzzle
        *@requires {@code j>0 && j<=tamanhoNumero}
        *@ensures {@code \result>0}
        */
        public static void jnesimoElemento(int num, int j, int tamanhoNumero) {
      
        int i= 1;
        int jDigit=0;
        int valorFixo2 = 0;
        int valorFixo1 = num;
        boolean j1= j>0 && j<=tamanhoNumero;
        if(j1) {
         for (int p = 1;p<=tamanhoNumero;p++){
            
            valorFixo2 = valorFixo1 %10;
            
            valorFixo1 = valorFixo1 / 10;

            if(p == tamanhoNumero - j + 1)
             jDigit = valorFixo2;
         }
        }
        }

       /**
        *Funcao que origina o numero inteiro que resulta de trocar os dígitos nas posições i e j do puzzle
        *
        *@param num o puzzle
        *@param i numero inteiro i
        *@param j numero inteiro j
        *@param tamanhoNumero numero de digitos do puzzle
        *@requires {@code j>0 && j<=tamanhoNumero && i>0 && i<=tamanhoNumero && i != j}
        *@ensures {@code \result>0}
        */
       public static void swapDigitiDigitJ(int num, int i,int j, int tamanhoNumero) {
      
        int h= 1;
        int jDigit1=0;
        int jDigit2=0;
        int valorFixo2 = 0;
        int valorFixo1 = num;
        int finalNumber = 0;
        boolean j1= j>0 && j<=tamanhoNumero;
        boolean i1= i>0 && i<=tamanhoNumero;
        
        if(j1 && i1 && i != j) {
         for (int p = 1;p<=tamanhoNumero;p++){
            
            valorFixo2 = valorFixo1 %10;
            
            valorFixo1 = valorFixo1 / 10;

            if(p == tamanhoNumero - j + 1)
                jDigit1 = valorFixo2;

            if(p == tamanhoNumero - i + 1)
                jDigit2 = valorFixo2;
         }

         valorFixo2 = 0;
         valorFixo1 = num;
         for (int p1 = 1;p1<=tamanhoNumero;p1++){
            
            valorFixo2 = valorFixo1 %10;
            
            valorFixo1 = valorFixo1 / 10;

            if(p1 == tamanhoNumero - j + 1)
                finalNumber = finalNumber + getNumber(p1-1,jDigit2); 
            else if(p1==tamanhoNumero - i + 1)
                finalNumber = finalNumber + getNumber(p1-1,jDigit1); 
            else
                finalNumber = finalNumber + getNumber(p1-1,valorFixo2);
         }
         }
       }
       
       /**
        *Funcao de auxilio para trocar os digitos i e j consoante o tamanho do puzzle
        *
        *@param tamanhoNumero numero de digitos do puzzle
        *@param valorDigito valor a que corresponde o digito
        *@requires {@code tamanhoNumero == 1 || tamanhoNumero == 2 || tamanhoNumero == 3 || tamanhoNumero == 4 || tamanhoNumero == 5 || tamanhoNumero == 6 || tamanhoNumero == 7 || 8 || 9}
        *@ensures {@code \result>0}
        *@return o numero inteiro r
        */
       public static int getNumber(int tamanhoNumero,int valorDigito) {
         int r = 0;

         if(tamanhoNumero == 1)
            r = valorDigito * 10;
         else if(tamanhoNumero == 2)
            r = valorDigito * 100;
        else if(tamanhoNumero == 3)
            r = valorDigito * 1000;
        else if(tamanhoNumero == 4)
            r = valorDigito * 10000;
        else if(tamanhoNumero == 5)
            r = valorDigito * 100000;
        else if(tamanhoNumero == 6)
            r = valorDigito * 1000000;
        else if(tamanhoNumero == 7)
            r = valorDigito * 10000000;
        else if(tamanhoNumero == 8)
            r = valorDigito * 100000000;
        else if(tamanhoNumero == 9)
            r = valorDigito * 1000000000;
        else 
            r = valorDigito;
        
        return r;
      }
        
        /**
        *Funcao que troca os dois ultimos digitos do puzzle
        *
        *@param num o puzzle
        *@param numPuzzleValido condicao caso o puzzle seja valido
        *@requires {@code numPuzzleValido=true}
        *@ensures {@code \result>0}
        */
        public static void swapLastDigits(int num, boolean numPuzzleValido) {
        
        int lastDigit= (num%100)/10;
        int penultimeDigit=(num%100)%10;
        int newNumber=((num/100)*100)+(penultimeDigit*10)+lastDigit;
        
        if(numPuzzleValido) {
        System.out.println("  > after swapping the last two digits: " +newNumber);      
        }
        }
        
        /**
        *Funcao que troca os dois primeiros digitos do puzzle
        *
        *@param num o puzzle
        *@param tamanhoNumero numero de digitos do puzzle
        *@param numPuzzleValido condicao caso o puzzle seja valido
        *@requires {@code numPuzzleValido=true && tamanhoNumero==3 || tamanhoNumero==5 || tamanhoNumero==7 || tamanhoNumero==9}
        *@ensures {@code \result>0}
        */
        public static void swapFirstDigits(int num, int tamanhoNumero, boolean numPuzzleValido) {
        
        if(numPuzzleValido) {
        if(tamanhoNumero==3){
        int firstDigit= (num/10)%10;
        int secondDigit= (num/10)/10;
        int newNumber2= firstDigit*100 + secondDigit*10 + num%10;
        System.out.println("  > after swapping the first two digits: " +newNumber2);
        }
        else if(tamanhoNumero==5) {
        int firstDigit= (num/1000)%10;
        int secondDigit= (num/1000)/10;
        int newNumber2= firstDigit*10000 + secondDigit*1000 + num%1000;
        System.out.println("  > after swapping the first two digits: " +newNumber2);
        }
        else if(tamanhoNumero==7) {
        int firstDigit= (num/100000)%10;
        int secondDigit= (num/100000)/10;
        int newNumber2= firstDigit*1000000 + secondDigit*100000 + num%100000;
        System.out.println("  > after swapping the first two digits: " +newNumber2);
        }
        else if(tamanhoNumero==9) {
        int firstDigit= (num/10000000)%10;
        int secondDigit= (num/10000000)/10;
        int newNumber2= firstDigit*100000000 + secondDigit*10000000 + num%10000000;
        System.out.println("  > after swapping the first two digits: " +newNumber2);
        }
        }
    }
}
 
