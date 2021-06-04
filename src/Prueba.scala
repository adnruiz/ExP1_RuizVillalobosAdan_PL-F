import scala.math._
import scala.io.StdIn._

object Prueba {

  def decimal_a_Binario(numero: Int): Array[Int]={
    var positivo=numero*(-1)
    var arr = new Array[Int](8)
    var i=7
    while (positivo!=0) {
      arr(i) = (positivo % 2)
      positivo =positivo/2;
      i=i-1
    }
    arr
  }

  def complementoA1(arr:Array[Int]):Array[Int]={
    var aux=7
    while (aux>=1) {
      if(arr(aux)==0){
        arr(aux)=1
      }else{
        arr(aux)=0
      }
      aux=aux-1
    }
    arr(0)=1
    arr
  }

  def complementoA2(arr:Array[Int]):Array[Int]={
    var acarreo: Int = 1

    for (x <- 7 to 1 by -1){
      if ( acarreo == 1){
        if (arr(x) == 1){
          arr(x) = 0
          acarreo = 1
        } else {
          arr(x) = 1
          acarreo = 0
        }
      }
    }
    arr
  }

  def pedirNumero(): Int={
    println("Ingrese numero negativo a convertir")
    var num = readInt()
    if(num<0&&num>=(-128)){
      num
    }else{
      println("Error")
      pedirNumero()
    }
  }

  def mosrarArreglo(arreglo: Array[Int]) : Unit ={
    for(elemento <- arreglo){
      print(elemento)
    }
  }

  def main(args: Array[String]): Unit ={
    var numero=pedirNumero()
    print("Numero en binario: ")
    mosrarArreglo(decimal_a_Binario(numero))

    println("\nNumero en binario complemento A1: ")
    mosrarArreglo(complementoA1(decimal_a_Binario(numero)))

    println("\nNumero en binario complemento A2: ")
    mosrarArreglo(complementoA2(complementoA1(decimal_a_Binario(numero))))

  }

}
