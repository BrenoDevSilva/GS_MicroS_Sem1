
🔧 Blackout Guardian – Backend  
API Spring Boot para gestão de eventos de apagões no Brasil, promovendo registro, análise e resposta inteligente a situações críticas.

---

📘 Sobre o Projeto  
Blackout Guardian é uma plataforma desenvolvida para fornecer suporte em casos de apagões elétricos. Esta API permite registrar eventos em localidades específicas, consultar ocorrências e integrar dados com fontes externas, como a API do tempo, para análise contextual.

---

👨‍💻 Integrantes do Grupo  
| Nome                     | RM      |
|--------------------------|---------|
| Anna Heloisa Soto Yagyu | 550360  |
| Breno da Silva Santos    | 99275   |
| Gustavo Kawamura Christofani | 99679 |

---

📋 Funcionalidades da API  
✅ Cadastro de eventos com dados como cidade, bairro, horários e descrição dos prejuízos  
✅ Listagem completa de todos os registros salvos  
✅ Filtro de eventos por cidade  
✅ Integração com OpenWeatherMap para exibir clima na hora do registro  
✅ Validações robustas (campos obrigatórios, datas futuras, etc.)

---

🛠️ Tecnologias Utilizadas  
- Java 17  
- Spring Boot 3.5  
- Spring Web  
- Spring Data JPA  
- PostgreSQL  
- Hibernate  
- Maven  
- OpenWeatherMap API  
- Bean Validation (Jakarta)  
- Lombok  

---

📂 Organização do Código  
```
/global-solution
│
├── /controller        → Endpoints REST (EventoController)
├── /dto               → Objetos de entrada e resposta (Request/Response)
├── /model             → Entidade JPA (Evento)
├── /repository        → Interface JPARepository
├── /service           → Lógica de negócio (EventoService, WeatherClient)
├── /resources
│   ├── application.properties
└── BlackoutGuardianApplication.java
```

---

💾 Banco de Dados  
Utiliza PostgreSQL com a base de dados chamada `blackoutdb`.

Exemplo de configuração no `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/blackoutdb
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

---

🔌 Integração com API do Tempo  
Durante o cadastro de eventos, a API consome dados em tempo real do [OpenWeatherMap](https://openweathermap.org/) para armazenar informações climáticas associadas ao apagão.

---

🧪 Como Rodar o Projeto  
```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/seu-repo.git

# Entrar no projeto
cd global-solution

# Compilar e rodar
./mvnw spring-boot:run
```

---

📬 Testes via Postman  
**Endpoint para cadastrar evento:**
```
POST http://localhost:8080/api/eventos
```

**Body (JSON):**
```json
{
  "cidade": "São Paulo",
  "bairro": "Mooca",
  "dataHoraInicio": "2025-06-05T18:00:00",
  "dataHoraFim": "2025-06-05T20:30:00",
  "descricaoPrejuizo": "Apagão afetou área residencial."
}
```

**Outros endpoints:**
- `GET /api/eventos` – lista todos
- `GET /api/eventos/{cidade}` – lista por cidade

---

✅ Critérios Atendidos  
| Critério                                           | Status |
|----------------------------------------------------|--------|
| Cadastro e listagem de eventos via API            | ✅     |
| Filtro por cidade                                  | ✅     |
| Integração com serviço externo (API do tempo)      | ✅     |
| Validações robustas e tratamento de erros          | ✅     |
| Banco de dados persistente com PostgreSQL          | ✅     |

---

🚀 Desenvolvido com dedicação para a Global Solution 2025.
