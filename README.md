# Test

Implementar un algoritmo el cual recibirá como parámetros una serie de líneas con inicio y fin. El algoritmo deberá ser capaz de crear nuevos rangos de líneas con inicio y fin si se superponen a otras creando rangos independientes y separados entre sí.
-	El algoritmo puede recibir n rangos.
-	El algoritmo arroja n rangos.

## Mejora del algoritmo

-	El algoritmo no puede crear nuevos rangos si el número mínimo y máximo de uno de ellos está contenido completamente dentro de otro rango.

Ejemplo:
Sí ingresa los rangos [3,9] y [4,6], el algoritmo no calculará de forma correcta el nuevo rango de valores dado que [4,6] está completamente contenido dentro del rango [3,9]

La forma de solucionarlo es encontrar cual ese rango que contiene a los demás y de esta forma reemplazar el resultado por este mismo.

## Casos de prueba

**Caso 1:**
[1,3] [5,7] [2,5]	

**Salida 1:**
[1,7]

**Caso 2:**
[12,18] [1,7] [6,9]						

**Salida 2:**
[1,9] [12,18]

**Caso 3:**
[3,7] [1,2] [2,5] [8,11] [12,16] [14,20] [10,12]		

**Salida 3:**
[1,7] [8,20]


## Complejidad
Decidí tener en cuenta dos casos para calcular la complejidad del algoritmo.

### Caso donde no hay intersecciones entre los rangos ingresados es O(n)

### Caso donde todos los rangos ingresados se vuelven intersecciones es O(n^2)



