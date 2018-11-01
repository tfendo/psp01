#TAREA PARA PSP01

##Ejercicio 2

* **Primera parte**  
Para probar el funcionamiento del programa \"**Lenguaje**" recurro de nuevo a la terminal de línea de comandos. Me sitúo en el directorio *dist* después de haber generado el fichero .jar y ejecuto la instrucción `java -jar Lenguaje.jar miFicheroDeLenguaje.txt`  
Se observa como responde el programa al pasarle un número incorrecto de parámetros.  

![Captura Lenguajes](https://github.com/tfendo/psp01/blob/master/Actividad_2/Capturas/Captura4.png)  

Ahora introduzco la sentencia de ejecución correcta `java -jar Lenguaje.jar 40 miFicheroDeLenguaje.txt` y observamos que el programa se ejecuta de forma satisfactoria.  

![Captura Lenguajes](https://github.com/tfendo/psp01/blob/master/Actividad_2/Capturas/Captura5.png)  

* **Segunda parte**
Una vez creado el programa \"**Colaborar**" y generado su fichero .jar, meto los ejecutables de ambos programas en una misma carpeta para facilitar su ejecución desde la terminal. A continuación ejecuto la siguiente instrucción:
```
java -jar Colaborar.jar miFicheroDeTexto.txt
```  
Y se puede obserbar como se van creando todos los procesos de la apliación \"**Lenguaje**". Por último ejecuto el comando `wc -l miFicheroDeLenguaje.txt` para contar el número de lineas del fichero creado y comprobar así el correcto funcionamiento del programa.  

![Captura Lenguajes](https://github.com/tfendo/psp01/blob/master/Actividad_2/Capturas/Captura6.png)  
