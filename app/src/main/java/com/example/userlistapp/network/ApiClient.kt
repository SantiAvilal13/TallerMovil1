package com.example.userlistapp.network

import com.example.userlistapp.data.*

class ApiClient {
    suspend fun getUsers(): UsersResponse {
        // Datos colombianos estáticos
        val colombianUsers = listOf(
            User(
                id = 1,
                firstName = "María",
                lastName = "González",
                maidenName = "Rodríguez",
                age = 28,
                gender = "female",
                email = "maria.gonzalez@email.com",
                phone = "+57 300 123 4567",
                username = "mariag",
                password = "password123",
                birthDate = "1995-03-15",
                image = "https://ui-avatars.com/api/?name=Maria+Gonzalez&background=6366f1&color=fff&size=200",
                bloodGroup = "O+",
                height = 165.0,
                weight = 58.0,
                eyeColor = "Brown",
                hair = Hair(color = "Black", type = "Straight"),
                ip = "192.168.1.1",
                address = Address(
                    address = "Carrera 15 #45-67",
                    city = "Bogotá",
                    state = "Cundinamarca",
                    stateCode = "CUN",
                    postalCode = "110111",
                    coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:B7",
                university = "Universidad Nacional de Colombia",
                bank = Bank(
                    cardExpire = "12/25",
                    cardNumber = "1234567890123456",
                    cardType = "Visa",
                    currency = "COP",
                    iban = "CO123456789012345678"
                ),
                company = Company(
                    department = "Tecnología",
                    name = "Bancolombia",
                    title = "Desarrolladora Senior",
                    address = Address(
                        address = "Calle 50 #46-36",
                        city = "Medellín",
                        state = "Antioquia",
                        stateCode = "ANT",
                        postalCode = "050001",
                        coordinates = Coordinates(lat = 6.2442, lng = -75.5812),
                        country = "Colombia"
                    )
                ),
                ein = "123456789",
                ssn = "987654321",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Bitcoin",
                    wallet = "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",
                    network = "Bitcoin"
                ),
                role = "admin"
            ),
            User(
                id = 2,
                firstName = "Carlos",
                lastName = "Martínez",
                maidenName = "López",
                age = 32,
                gender = "male",
                email = "carlos.martinez@email.com",
                phone = "+57 301 987 6543",
                username = "carlosm",
                password = "password456",
                birthDate = "1991-08-22",
                image = "https://ui-avatars.com/api/?name=Carlos+Martinez&background=059669&color=fff&size=200",
                bloodGroup = "A+",
                height = 178.0,
                weight = 75.0,
                eyeColor = "Brown",
                hair = Hair(color = "Black", type = "Curly"),
                ip = "192.168.1.2",
                address = Address(
                    address = "Calle 72 #10-34",
                    city = "Medellín",
                    state = "Antioquia",
                    stateCode = "ANT",
                    postalCode = "050010",
                    coordinates = Coordinates(lat = 6.2442, lng = -75.5812),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:B8",
                university = "Universidad de Antioquia",
                bank = Bank(
                    cardExpire = "06/26",
                    cardNumber = "9876543210987654",
                    cardType = "MasterCard",
                    currency = "COP",
                    iban = "CO987654321098765432"
                ),
                company = Company(
                    department = "Ventas",
                    name = "Grupo Éxito",
                    title = "Gerente de Ventas",
                    address = Address(
                        address = "Carrera 48 #32B-78",
                        city = "Medellín",
                        state = "Antioquia",
                        stateCode = "ANT",
                        postalCode = "050015",
                        coordinates = Coordinates(lat = 6.2442, lng = -75.5812),
                        country = "Colombia"
                    )
                ),
                ein = "987654321",
                ssn = "123456789",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Ethereum",
                    wallet = "0x742d35Cc6634C0532925a3b8D4C0C8b3",
                    network = "Ethereum"
                ),
                role = "user"
            ),
            User(
                id = 3,
                firstName = "Ana",
                lastName = "Ramírez",
                maidenName = "Vargas",
                age = 26,
                gender = "female",
                email = "ana.ramirez@email.com",
                phone = "+57 302 456 7890",
                username = "anar",
                password = "password789",
                birthDate = "1997-12-03",
                image = "https://ui-avatars.com/api/?name=Ana+Ramirez&background=dc2626&color=fff&size=200",
                bloodGroup = "B+",
                height = 160.0,
                weight = 52.0,
                eyeColor = "Green",
                hair = Hair(color = "Brown", type = "Wavy"),
                ip = "192.168.1.3",
                address = Address(
                    address = "Carrera 7 #127-45",
                    city = "Bogotá",
                    state = "Cundinamarca",
                    stateCode = "CUN",
                    postalCode = "110221",
                    coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:B9",
                university = "Universidad de los Andes",
                bank = Bank(
                    cardExpire = "09/27",
                    cardNumber = "5555444433332222",
                    cardType = "Visa",
                    currency = "COP",
                    iban = "CO555544443333222211"
                ),
                company = Company(
                    department = "Marketing",
                    name = "Avianca",
                    title = "Especialista en Marketing Digital",
                    address = Address(
                        address = "Avenida El Dorado #103-15",
                        city = "Bogotá",
                        state = "Cundinamarca",
                        stateCode = "CUN",
                        postalCode = "110911",
                        coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                        country = "Colombia"
                    )
                ),
                ein = "555444333",
                ssn = "222111000",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Litecoin",
                    wallet = "LTC1qw508d6qejxtdg4y5r3zarvary0c5xw7k",
                    network = "Litecoin"
                ),
                role = "user"
            ),
            User(
                id = 4,
                firstName = "Luis",
                lastName = "Hernández",
                maidenName = "Castro",
                age = 35,
                gender = "male",
                email = "luis.hernandez@email.com",
                phone = "+57 304 123 9876",
                username = "luish",
                password = "password101",
                birthDate = "1988-05-14",
                image = "https://ui-avatars.com/api/?name=Luis+Hernandez&background=7c3aed&color=fff&size=200",
                bloodGroup = "AB+",
                height = 175.0,
                weight = 70.0,
                eyeColor = "Brown",
                hair = Hair(color = "Black", type = "Straight"),
                ip = "192.168.1.4",
                address = Address(
                    address = "Calle 26 #68-15",
                    city = "Cali",
                    state = "Valle del Cauca",
                    stateCode = "VAC",
                    postalCode = "760001",
                    coordinates = Coordinates(lat = 3.4516, lng = -76.5320),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:C0",
                university = "Universidad del Valle",
                bank = Bank(
                    cardExpire = "03/28",
                    cardNumber = "4444333322221111",
                    cardType = "Visa",
                    currency = "COP",
                    iban = "CO444433332222111100"
                ),
                company = Company(
                    department = "Ingeniería",
                    name = "Ecopetrol",
                    title = "Ingeniero de Sistemas",
                    address = Address(
                        address = "Carrera 13 #36-24",
                        city = "Bogotá",
                        state = "Cundinamarca",
                        stateCode = "CUN",
                        postalCode = "110311",
                        coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                        country = "Colombia"
                    )
                ),
                ein = "444333222",
                ssn = "111000999",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Cardano",
                    wallet = "addr1qx2fxv2umyhttkxyxp8x0dlpdt3k6cwng5pxj3jhsydzer3jcu5d8ps7zex2k2xt3uqxgjqnnj0vs2qd4a6gtmk4l3zcjqnkszr",
                    network = "Cardano"
                ),
                role = "user"
            ),
            User(
                id = 5,
                firstName = "Sofía",
                lastName = "López",
                maidenName = "Morales",
                age = 29,
                gender = "female",
                email = "sofia.lopez@email.com",
                phone = "+57 305 654 3210",
                username = "sofial",
                password = "password202",
                birthDate = "1994-11-08",
                image = "https://ui-avatars.com/api/?name=Sofia+Lopez&background=ea580c&color=fff&size=200",
                bloodGroup = "O-",
                height = 168.0,
                weight = 55.0,
                eyeColor = "Hazel",
                hair = Hair(color = "Brown", type = "Curly"),
                ip = "192.168.1.5",
                address = Address(
                    address = "Carrera 80 #53-45",
                    city = "Barranquilla",
                    state = "Atlántico",
                    stateCode = "ATL",
                    postalCode = "080001",
                    coordinates = Coordinates(lat = 10.9639, lng = -74.7964),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:C1",
                university = "Universidad del Norte",
                bank = Bank(
                    cardExpire = "11/26",
                    cardNumber = "3333222211110000",
                    cardType = "American Express",
                    currency = "COP",
                    iban = "CO333322221111000099"
                ),
                company = Company(
                    department = "Recursos Humanos",
                    name = "Claro Colombia",
                    title = "Coordinadora de Talento Humano",
                    address = Address(
                        address = "Calle 67 #7-37",
                        city = "Bogotá",
                        state = "Cundinamarca",
                        stateCode = "CUN",
                        postalCode = "110231",
                        coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                        country = "Colombia"
                    )
                ),
                ein = "333222111",
                ssn = "000999888",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Polkadot",
                    wallet = "15oF4uVJwmo4TdGW7VfQxNLavjCXviqxT9S1MgbjMNHr6Sp5",
                    network = "Polkadot"
                ),
                role = "user"
            ),
            User(
                id = 6,
                firstName = "Diego",
                lastName = "Vargas",
                maidenName = "Jiménez",
                age = 31,
                gender = "male",
                email = "diego.vargas@email.com",
                phone = "+57 306 789 0123",
                username = "diegov",
                password = "password303",
                birthDate = "1992-07-20",
                image = "https://ui-avatars.com/api/?name=Diego+Vargas&background=0891b2&color=fff&size=200",
                bloodGroup = "A-",
                height = 180.0,
                weight = 78.0,
                eyeColor = "Blue",
                hair = Hair(color = "Brown", type = "Wavy"),
                ip = "192.168.1.6",
                address = Address(
                    address = "Calle 19 #4-62",
                    city = "Cartagena",
                    state = "Bolívar",
                    stateCode = "BOL",
                    postalCode = "130001",
                    coordinates = Coordinates(lat = 10.3910, lng = -75.4794),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:C2",
                university = "Universidad de Cartagena",
                bank = Bank(
                    cardExpire = "08/27",
                    cardNumber = "2222111100009999",
                    cardType = "MasterCard",
                    currency = "COP",
                    iban = "CO222211110000999988"
                ),
                company = Company(
                    department = "Operaciones",
                    name = "Terpel",
                    title = "Supervisor de Operaciones",
                    address = Address(
                        address = "Carrera 9 #99-02",
                        city = "Bogotá",
                        state = "Cundinamarca",
                        stateCode = "CUN",
                        postalCode = "110221",
                        coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                        country = "Colombia"
                    )
                ),
                ein = "222111000",
                ssn = "999888777",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Chainlink",
                    wallet = "0x742d35Cc6634C0532925a3b8D4C0C8b4",
                    network = "Ethereum"
                ),
                role = "user"
            ),
            User(
                id = 7,
                firstName = "Valentina",
                lastName = "Ruiz",
                maidenName = "Peña",
                age = 24,
                gender = "female",
                email = "valentina.ruiz@email.com",
                phone = "+57 307 456 7891",
                username = "valentinar",
                password = "password404",
                birthDate = "1999-02-28",
                image = "https://ui-avatars.com/api/?name=Valentina+Ruiz&background=be185d&color=fff&size=200",
                bloodGroup = "B-",
                height = 162.0,
                weight = 50.0,
                eyeColor = "Green",
                hair = Hair(color = "Blonde", type = "Straight"),
                ip = "192.168.1.7",
                address = Address(
                    address = "Carrera 43A #34-95",
                    city = "Medellín",
                    state = "Antioquia",
                    stateCode = "ANT",
                    postalCode = "050021",
                    coordinates = Coordinates(lat = 6.2442, lng = -75.5812),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:C3",
                university = "Universidad EAFIT",
                bank = Bank(
                    cardExpire = "05/29",
                    cardNumber = "1111000099998888",
                    cardType = "Visa",
                    currency = "COP",
                    iban = "CO111100009999888877"
                ),
                company = Company(
                    department = "Diseño",
                    name = "Rappi",
                    title = "Diseñadora UX/UI",
                    address = Address(
                        address = "Carrera 11A #93-07",
                        city = "Bogotá",
                        state = "Cundinamarca",
                        stateCode = "CUN",
                        postalCode = "110221",
                        coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                        country = "Colombia"
                    )
                ),
                ein = "111000999",
                ssn = "888777666",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Solana",
                    wallet = "7xKXtg2CW87d97TXJSDpbD5jBkheTqA83TZRuJosgAsU",
                    network = "Solana"
                ),
                role = "user"
            ),
            User(
                id = 8,
                firstName = "Andrés",
                lastName = "Torres",
                maidenName = "Silva",
                age = 38,
                gender = "male",
                email = "andres.torres@email.com",
                phone = "+57 308 234 5678",
                username = "andrest",
                password = "password505",
                birthDate = "1985-09-12",
                image = "https://ui-avatars.com/api/?name=Andres+Torres&background=16a34a&color=fff&size=200",
                bloodGroup = "O+",
                height = 177.0,
                weight = 82.0,
                eyeColor = "Brown",
                hair = Hair(color = "Black", type = "Short"),
                ip = "192.168.1.8",
                address = Address(
                    address = "Calle 116 #7-15",
                    city = "Bogotá",
                    state = "Cundinamarca",
                    stateCode = "CUN",
                    postalCode = "110111",
                    coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:C4",
                university = "Universidad Javeriana",
                bank = Bank(
                    cardExpire = "02/30",
                    cardNumber = "0000999988887777",
                    cardType = "MasterCard",
                    currency = "COP",
                    iban = "CO000099998888777766"
                ),
                company = Company(
                    department = "Finanzas",
                    name = "Davivienda",
                    title = "Analista Financiero Senior",
                    address = Address(
                        address = "Carrera 9 #72-21",
                        city = "Bogotá",
                        state = "Cundinamarca",
                        stateCode = "CUN",
                        postalCode = "110231",
                        coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                        country = "Colombia"
                    )
                ),
                ein = "000999888",
                ssn = "777666555",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Avalanche",
                    wallet = "X-avax1x459sj0ssaegsjyp9vuzkmmfdkdmqe7pfu5kfq",
                    network = "Avalanche"
                ),
                role = "user"
            ),
            User(
                id = 9,
                firstName = "Isabella",
                lastName = "Mendoza",
                maidenName = "Restrepo",
                age = 27,
                gender = "female",
                email = "isabella.mendoza@email.com",
                phone = "+57 309 876 5432",
                username = "isabellam",
                password = "password606",
                birthDate = "1996-04-18",
                image = "https://ui-avatars.com/api/?name=Isabella+Mendoza&background=ca8a04&color=fff&size=200",
                bloodGroup = "AB-",
                height = 170.0,
                weight = 60.0,
                eyeColor = "Brown",
                hair = Hair(color = "Black", type = "Long"),
                ip = "192.168.1.9",
                address = Address(
                    address = "Carrera 70 #52-49",
                    city = "Medellín",
                    state = "Antioquia",
                    stateCode = "ANT",
                    postalCode = "050034",
                    coordinates = Coordinates(lat = 6.2442, lng = -75.5812),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:C5",
                university = "Universidad Pontificia Bolivariana",
                bank = Bank(
                    cardExpire = "07/28",
                    cardNumber = "9999888877776666",
                    cardType = "Visa",
                    currency = "COP",
                    iban = "CO999988887777666655"
                ),
                company = Company(
                    department = "Comunicaciones",
                    name = "Caracol Televisión",
                    title = "Productora de Contenidos",
                    address = Address(
                        address = "Calle 76 #11-35",
                        city = "Bogotá",
                        state = "Cundinamarca",
                        stateCode = "CUN",
                        postalCode = "110221",
                        coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                        country = "Colombia"
                    )
                ),
                ein = "999888777",
                ssn = "666555444",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Polygon",
                    wallet = "0x742d35Cc6634C0532925a3b8D4C0C8b5",
                    network = "Polygon"
                ),
                role = "user"
            ),
            User(
                id = 10,
                firstName = "Sebastián",
                lastName = "Castillo",
                maidenName = "Guerrero",
                age = 33,
                gender = "male",
                email = "sebastian.castillo@email.com",
                phone = "+57 310 345 6789",
                username = "sebastianc",
                password = "password707",
                birthDate = "1990-12-25",
                image = "https://ui-avatars.com/api/?name=Sebastian+Castillo&background=9333ea&color=fff&size=200",
                bloodGroup = "A+",
                height = 183.0,
                weight = 85.0,
                eyeColor = "Green",
                hair = Hair(color = "Brown", type = "Curly"),
                ip = "192.168.1.10",
                address = Address(
                    address = "Calle 85 #15-32",
                    city = "Bucaramanga",
                    state = "Santander",
                    stateCode = "SAN",
                    postalCode = "680001",
                    coordinates = Coordinates(lat = 7.1193, lng = -73.1227),
                    country = "Colombia"
                ),
                macAddress = "00:1B:44:11:3A:C6",
                university = "Universidad Industrial de Santander",
                bank = Bank(
                    cardExpire = "10/29",
                    cardNumber = "8888777766665555",
                    cardType = "MasterCard",
                    currency = "COP",
                    iban = "CO888877776666555544"
                ),
                company = Company(
                    department = "Logística",
                    name = "Servientrega",
                    title = "Coordinador de Logística",
                    address = Address(
                        address = "Calle 26 #69-76",
                        city = "Bogotá",
                        state = "Cundinamarca",
                        stateCode = "CUN",
                        postalCode = "110911",
                        coordinates = Coordinates(lat = 4.7110, lng = -74.0721),
                        country = "Colombia"
                    )
                ),
                ein = "888777666",
                ssn = "555444333",
                userAgent = "Mozilla/5.0",
                crypto = Crypto(
                    coin = "Cosmos",
                    wallet = "cosmos1x459sj0ssaegsjyp9vuzkmmfdkdmqe7pfu5kfq",
                    network = "Cosmos"
                ),
                role = "user"
            )
        )
        
        return UsersResponse(
            users = colombianUsers,
            total = colombianUsers.size,
            skip = 0,
            limit = colombianUsers.size
        )
    }

    fun close() {
        // No hay cliente HTTP que cerrar
    }
}