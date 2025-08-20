// Avatar con borde gradiente e indicador online
Box(modifier = Modifier.size(60.dp)) {
    // Borde exterior con gradiente
    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                        MaterialTheme.colorScheme.secondary.copy(alpha = 0.8f),
                        MaterialTheme.colorScheme.tertiary.copy(alpha = 0.8f)
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
    
    // Indicador de estado online
    Box(
        modifier = Modifier
            .size(16.dp)
            .offset(x = 44.dp, y = 44.dp)
            .clip(CircleShape)
            .background(Color(0xFF4CAF50))
    )
}