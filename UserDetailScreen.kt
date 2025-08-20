// Imagen de perfil grande con efectos avanzados
Box(modifier = Modifier.size(150.dp)) {
    // Sombra de fondo
    Box(
        modifier = Modifier
            .size(170.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                        Color.Transparent
                    ),
                    radius = 85f
                )
            )
    )
    
    // Borde decorativo con gradiente
    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.colorScheme.tertiary
                    )
                )
            )
    ) {
        AsyncImage(
            model = user.image,
            contentDescription = "Foto de perfil de ${user.firstName}",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface),
            contentScale = ContentScale.Crop
        )
    }
    
    // Indicador de estado online más grande
    Box(
        modifier = Modifier
            .size(24.dp)
            .offset(x = 55.dp, y = 55.dp)
            .clip(CircleShape)
            .background(Color(0xFF4CAF50))
    )
}