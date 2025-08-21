package com.example.userlistapp.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.userlistapp.data.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(
    user: User,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top App Bar
        TopAppBar(
            title = { Text("${user.firstName} ${user.lastName}") },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen de perfil grande mejorada
            Box(
                modifier = Modifier.size(150.dp),
                contentAlignment = Alignment.Center
            ) {
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
                
                // Borde exterior decorativo
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
                        .padding(4.dp)
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
                        .size(24.dp)
                        .offset(x = 55.dp, y = 55.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF4CAF50))
                        .padding(3.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre completo
            Text(
                text = "${user.firstName} ${user.lastName}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Información básica simplificada
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                InfoCard(
                    title = "Información Personal"
                ) {
                    InfoRow("Edad", "${user.age} años")
                    InfoRow("Género", user.gender.replaceFirstChar { it.uppercase() })
                    InfoRow("Email", user.email)
                    InfoRow(
                        "Teléfono", 
                        user.phone, 
                        isClickable = true,
                        onClick = { dialPhoneNumber(context, user.phone) }
                    )
                    InfoRow("Usuario", "@${user.username}")
                    InfoRow("Fecha de nacimiento", user.birthDate)
                    InfoRow("Grupo sanguíneo", user.bloodGroup)
                    InfoRow("Altura", "${user.height} cm")
                    InfoRow("Peso", "${user.weight} kg")
                }

                InfoCard(
                    title = "Información Laboral"
                ) {
                    InfoRow("Empresa", user.company.name)
                    InfoRow("Cargo", user.company.title)
                    InfoRow("Departamento", user.company.department)
                    InfoRow("Dirección empresa", "${user.company.address.address}, ${user.company.address.city}")
                    InfoRow("Universidad", user.university)
                }

                InfoCard(
                    title = "Apariencia Física"
                ) {
                    InfoRow("Color de ojos", user.eyeColor)
                    InfoRow("Color de cabello", user.hair.color)
                    InfoRow("Tipo de cabello", user.hair.type)
                }

                InfoCard(
                    title = "Ubicación"
                ) {
                    InfoRow("Dirección", user.address.address)
                    InfoRow("Ciudad", user.address.city)
                    InfoRow("Estado", user.address.state)
                    InfoRow("País", user.address.country)
                    InfoRow("Código postal", user.address.postalCode)
                    InfoRow("Coordenadas", "${user.address.coordinates.lat}, ${user.address.coordinates.lng}")
                }

                InfoCard(
                    title = "Información Bancaria"
                ) {
                    InfoRow("Número de tarjeta", "**** **** **** ${user.bank.cardNumber.takeLast(4)}")
                    InfoRow("Tipo de tarjeta", user.bank.cardType)
                    InfoRow("Moneda", user.bank.currency)
                    InfoRow("IBAN", user.bank.iban)
                }

                InfoCard(
                    title = "Criptomonedas"
                ) {
                    InfoRow("Moneda", user.crypto.coin)
                    InfoRow("Wallet", user.crypto.wallet)
                    InfoRow("Red", user.crypto.network)
                }
            }
        }
    }
}

@Composable
fun InfoCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            content()
        }
    }
}

@Composable
fun InfoRow(
    label: String,
    value: String,
    isClickable: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (isClickable && onClick != null) {
                    Modifier.clickable { onClick() }
                } else {
                    Modifier
                }
            )
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = if (isClickable) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(2f)
        )
        if (isClickable) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Llamar",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

private fun dialPhoneNumber(context: Context, phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    context.startActivity(intent)
}