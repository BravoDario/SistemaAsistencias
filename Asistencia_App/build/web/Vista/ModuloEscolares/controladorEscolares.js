 export function agregarFecha() {
      // Obtén el contenedor de fechas
      const fechasContainer = document.getElementById('fechasContainer');

      // Obtén el primer input de fecha dentro del contenedor
      const primerInput = fechasContainer.querySelector('input[type="date"]');

      // Clona el primer input y agrega la copia al contenedor
      const nuevaFecha = primerInput.cloneNode(true);
      fechasContainer.appendChild(nuevaFecha);
    }