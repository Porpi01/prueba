
//Monica Alcañiz Puig
//Ejercicio modificado para gitHub
//VOy a hacer un push y un pull

package tema6ejercicio11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase: tema6ejercicio11
 * 
 * @author: Mónica Alcañiz Puig
 * @version: 21 de marzo de 2023
 * 
 */

public class tema6ejercicio11 {

	static final int COLUMNAS = 10;
	static final int FILAS = 15;
	static final int RESPUESTA_CORRECTA = 1;
	static final double RESPUESTA_INCORRECTA = 0.5;

	/**
	 * Función imprimir Matriz
	 *
	 * @param matriz: Array bidimensional que se utiliza para imprimir cualquier
	 *                matriz
	 * @return no devuelve nada porque es void
	 */

	static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {

				System.out.println("Fila " + i + " Columna " + j + " Respuesta" + " : " + matriz[i][j]);
			}
			System.out.println();
		}

	}

	/**
	 * Función imprimirMenu el cual tiene 7 opciones
	 * 
	 * @return no devuelve nada porque es void
	 */
	static void imprimirMenu() {
		System.out.println("Escoge una opcion");
		System.out.println("1. Mostrar respuestas alumno");
		System.out.println("2. Mostrar respuestas examenes");
		System.out.println("3. Mostrar nota de un alumno");
		System.out.println("4. Mostrar nota todos los alumnos");
		System.out.println("5. Averiguar cuántos alumnos han fallado la pregunta");
		System.out.println("6. Averiguar cuál es la pregunta en la que ha habido más fallos");
		System.out.println("7. Averiguar cuál es la pregunta que más alumnos han dejado en blanco");

	}

	/**
	 * Método: calcularNotaAlumno
	 * 
	 * @param respuestasCorrectas: Parámetro dónde se almacenan las respuestas
	 *                             correctas,utilizado para comprobar si la
	 *                             respuesta dada por el alumno es correcta
	 * @param matrizAlumnos:       Parámetro dónde se almacenan las respuestas de
	 *                             los alumnos. Se utiliza para comprobar si la
	 *                             respuesta dada por el alumno es correcta
	 * @param índiceAlumno:        utilizado para saber de cuál alumno queremos
	 *                             saber la nota
	 * @return notas, variable de tipo int
	 */
	static double[] calcularNotaAlumno(int respuestasCorrectas[], int matrizAlumnos[][], int índiceAlumno) {

		double[] notas = new double[FILAS];

		for (int i = 0; i < matrizAlumnos.length; i++) {
			double notaAlumno = 0;
			if (matrizAlumnos[índiceAlumno] == matrizAlumnos[i]) {
				for (int j = 0; j < matrizAlumnos[i].length; j++) {
					if (matrizAlumnos[i][j] == respuestasCorrectas[j]) {
						notaAlumno = +RESPUESTA_CORRECTA;
					} else {
						notaAlumno = -RESPUESTA_INCORRECTA;
					}
				}
				notas[i] = notaAlumno;
			}
		}

		return notas;
	}

	/**
	 * Método calcularNotas de todos los alumnos
	 * 
	 * @param respuestasCorrectas: Parámetro dónde se almacenan las respuestas
	 *                             correctas,utilizado para comprobar si la
	 *                             respuesta dada por el alumno es correcta
	 * @param matrizAlumnos:       Parámetro dónde se almacenan las respuestas de
	 *                             los alumnos. Se utiliza para comprobar si la
	 *                             respuesta dada por el alumno es correcta
	 * @return notas, variable de tipo int
	 */

	static double[] calcularNotas(int respuestasCorrectas[], int matrizAlumnos[][]) {

		double[] notas = new double[FILAS];

		for (int i = 0; i < matrizAlumnos.length; i++) {

			double notaAlumno = 0;
			for (int j = 0; j < matrizAlumnos[i].length; j++) {
				if (matrizAlumnos[i][j] == respuestasCorrectas[j]) {
					notaAlumno = +RESPUESTA_CORRECTA;
				} else {
					notaAlumno = -RESPUESTA_INCORRECTA;
				}
			}
			notas[i] = notaAlumno;
		}

		return notas;
	}

	/**
	 * Método calcularAlumnosHanFallado
	 * 
	 * @@param respuestasCorrectas: Paámetro dónde se almacenan las respuestas
	 *         correctas,utilizado para comprobar si la respuesta dada por el alumno
	 *         es correcta
	 * @param matrizAlumnos:  Parámetro dónde se almacenan las respuestas de los
	 *                        alumnos. Se utiliza para comprobar si la respuesta
	 *                        dada por el alumno es correcta
	 * @param índicePregunta. Parámetro para saber de cuál pregunta queremos saber
	 *                        el número de alumnos que han fallado
	 * @return alumnos, variable de tipo int, para saber el número de alumnos que
	 *         han fallado la pregunta
	 */

	static int calcularAlumnosHanFallado(int respuestasCorrectas[], int matrizAlumnos[][], int índicePregunta) {
		int alumnos = 0;

		for (int i = 0; i < matrizAlumnos.length; i++) {

			if (matrizAlumnos[i][índicePregunta] != respuestasCorrectas[índicePregunta]) {
				alumnos++;

			}

		}
		return alumnos;
	}

	/**
	 * Método mostrarRespuestaAlumno
	 * 
	 * @param matrizAlumnos. Parámetro utilizado para saber las respuestas de los
	 *                       alumnos
	 * @param índiceAlumno.  Parámetro utilizado para especificar de cuál alumno
	 *                       queremos saber las respuestas
	 * @return No devuelve nada porque es void
	 */

	static void mostrarRespuestaAlumno(int matrizAlumnos[][], int índiceAlumno) {

		for (int i = 0; i < matrizAlumnos.length; i++) {
			if (matrizAlumnos[i] == matrizAlumnos[índiceAlumno]) {
				for (int j = 0; j < matrizAlumnos[i].length; j++) {
					índiceAlumno = matrizAlumnos[i][j];
					System.out.println("La respuesta es " + índiceAlumno);

				}

			}
		}

	}

	/**
	 * Método calcularPreguntasMasFalladas
	 * 
	 * @param respuestasCorrectas: Parámetro utilizado para comparar las respuestas
	 *                             de los alumnos con las respuestas correctas
	 * @param matrizAlumnos:       Parámetro utilizado para recorrer la
	 *                             matrizAlumnos y saber las respuestas dadas por
	 *                             ellos
	 * @return mayor, variable de tipo int que devuelve la pregunta más fallada
	 */
	static int calcularPreguntaMasFallada(int respuestasCorrectas[], int matrizAlumnos[][]) {
		int fallos[] = new int[FILAS];
		int mayor = 0;

		for (int i = 0; i < matrizAlumnos.length; i++) {
			int contador = 0;
			for (int j = 0; j < matrizAlumnos[i].length; j++) {
				if (respuestasCorrectas[j] != matrizAlumnos[i][j] && matrizAlumnos[i][j] != 0) {
					fallos[j]++;

				}
				if (fallos[j] > mayor) {
					mayor = j;

				}
			}

		}
		return mayor;

	}

	/**
	 * Método preguntaMasBlanco
	 * 
	 * @param matrizAlumnos: parámetro utilizado para saber las respuestas de cada
	 *                       alumno
	 * @return mayor, variable de tipo int dónde se almacena la pregunta más dejada
	 *         en blanco
	 */
	static int preguntaMasBlanco(int matrizAlumnos[][]) {
		int blanco[] = new int[FILAS];
		int mayor = 0;
		for (int i = 0; i < matrizAlumnos.length; i++) {

			for (int j = 0; j < matrizAlumnos[i].length; j++) {
				if (matrizAlumnos[i][j] == 0) {
					blanco[j]++;
				}
				if (blanco[j] > mayor) {

					mayor = j;
				}

			}

		}
		return mayor;
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Random azar = new Random();
		int respuestasCorrectas[] = new int[FILAS];
		int matrizAlumnos[][] = new int[FILAS][COLUMNAS];
		double[] notas = new double[FILAS];
		int opcion;
		int índiceAlumno;
		double notaAlumno = 0;
		String linea;

		/*
		 * Lectura del fichero respuestas.txt donde se almacenan las respuestas escritas
		 * a mano
		 */
		try {
			FileReader fr = new FileReader("respuestas.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner s = new Scanner(br);
			for (int i = 0; i < respuestasCorrectas.length; i++) {
				respuestasCorrectas[i] = s.nextInt();
			}
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Bucle for donde se realiza una lectura de la matrizAlumno y se introducen los
		// valores aleatoriamnete

		for (int i = 0; i < matrizAlumnos.length; i++) {

			for (int j = 0; j < matrizAlumnos[i].length; j++) {
				matrizAlumnos[i][j] = azar.nextInt(4);
			}
		}

		do {

			imprimirMenu();
			opcion = entrada.nextInt();

			switch (opcion) {

			case 1:

				System.out.println("¿De cuál alumno quieres mirar las respuestas?");
				índiceAlumno = entrada.nextInt();
				mostrarRespuestaAlumno(matrizAlumnos, índiceAlumno);

				break;

			case 2:

				for (int i = 0; i < matrizAlumnos.length; i++) {

					for (int j = 0; j < matrizAlumnos[i].length; j++) {

					}
				}
				imprimirMatriz(matrizAlumnos);

				break;
			case 3:
				System.out.println("¿De cuál alumno quieres mirar la nota?");
				índiceAlumno = entrada.nextInt();

				notas = calcularNotaAlumno(respuestasCorrectas, matrizAlumnos, índiceAlumno);

				System.out.println(notas[índiceAlumno]);

				break;
			case 4:
				notas = calcularNotas(respuestasCorrectas, matrizAlumnos);
				for (int i = 0; i < notas.length; i++) {
					System.out.println(notas[i]);

				}

				break;
			case 5:
				int índicePregunta = 0;

				System.out.println("¿Cuál pregunta quieres mirar?");
				índicePregunta = entrada.nextInt();
				System.out.println(calcularAlumnosHanFallado(respuestasCorrectas, matrizAlumnos, índicePregunta));

				break;
			case 6:

				System.out.println(
						"La pregunta más fallada es " + calcularPreguntaMasFallada(respuestasCorrectas, matrizAlumnos));

				break;
			case 7:

				System.out.println("La pregunta más dejada en blanco es " + preguntaMasBlanco(matrizAlumnos));

				break;
			case 8:
				System.out.println("Fin del programa");

				break;
			default:
				System.out.println("Error");

			}

		} while (opcion != 8);

	}

}
