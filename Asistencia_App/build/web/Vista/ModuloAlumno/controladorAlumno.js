// Función para mostrar o ocultar el card de asistencia
  function toggleAsistenciaCard() {
    const asistenciaCard = document.getElementById('asistenciaCard');
    asistenciaCard.classList.toggle('d-none');
  }

  // Función para mostrar información en el card de asistencia
  function mostrarInformacion(dia, profesor) {
    // Aquí puedes realizar acciones específicas cuando se hace clic en una celda
    // Por ahora, simplemente mostraremos u ocultaremos el card de asistencia
    toggleAsistenciaCard();
  }