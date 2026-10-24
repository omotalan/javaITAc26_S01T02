# Excepcions
**Descripció**: Sprint 1, Tasca 2, Nivell 1, Exercici 1

## 📌 Exercici 1 – Excepcions personalitzades i control d’errors

```
Objectius

    Crear una excepció personalitzada i saber com es llença i es captura.
    Treballar amb col·leccions (ArrayList<Product>) i càlculs sobre dades.
    Detectar i gestionar errors habituals com IndexOutOfBoundsException.

Enunciat

Imagina que estàs desenvolupant una petita aplicació per gestionar vendes. Cada venda pot incloure diversos productes, i el sistema ha de ser capaç de calcular el total. Ara bé, no tindria sentit fer aquest càlcul si encara no s'ha afegit cap producte. Per això, implementarem una comprovació per evitar-ho.

Comença definint una classe Product amb dos atributs: name i price. Aquesta classe representarà un producte individual dins la venda.

Després, crea una classe Sale, que ha de contenir una col·lecció de productes (per exemple, una ArrayList<Product>) i una variable per emmagatzemar el total (totalPrice). Aquesta classe inclourà un mètode calculateTotal() que:

    Comprovi si la col·lecció està buida.
    Si està buida, llenci una excepció personalitzada anomenada EmptySaleException, amb el missatge: "Per fer una venda primer has d’afegir productes".
    Si hi ha productes, sumi els preus i desi el total a l’atribut totalPrice.

La classe EmptySaleException ha de ser filla de Exception, i ha d’incloure aquest missatge en el seu constructor.

A més, afegeix una prova per generar una excepció IndexOutOfBoundsException, per exemple intentant accedir a una posició inexistent d'una llista, i captura-la mostrant el missatge d'error. Aquesta és una excepció habitual en Java quan es manipulen col·leccions sense fer les comprovacions adequades.

Per acabar, canvia la classe EmptySaleException perquè extengui d’una excepció en temps d’execució, com per exemple RuntimeException.

Saps què significa això? Quina diferència hi ha entre una excepció verificada (checked) i una no verificada (unchecked) com RuntimeException?
```

## ✨ Funcionalitats (si és aplicable)
Aquí l'objectiu és exposar un error, però també l'ús de l'excepció pel mètode calculateTotal(). Per cert, no comprenc 
molt bé el perquè que calculateTotal() visqui dins de Sale. En una miniaplicació com aquesta, ok, però hauria de ser 
dins una classe com Helpers, no?

A més a més, he afegit un Record per diferenciar cada tipus d'item amb les seves característiques.
El Record ElectronicItem no s'utilitza, és només un exemple.

L'excepció hereta de RuntimeException, com demana l'exercici al final.

## 🛠 Tecnologies
- Backend: Java

## 🚀 Instal·lació i Execució
1. Clonar el repositori: `git clone javaITAc26_S01T02`
2. Execució del "Main"


## 📸 Demo
Nota: El output esperat és un error.
```bash
Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 5 out of bounds for length 4
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
	at java.base/java.util.Objects.checkIndex(Objects.java:385)
	at java.base/java.util.ArrayList.get(ArrayList.java:427)
	at n01_e01_excepcions.saleTypes.Sale.getListItem(Sale.java:17)
	at n01_e01_excepcions.Main.main(Main.java:21)

Process finished with exit code 1
```