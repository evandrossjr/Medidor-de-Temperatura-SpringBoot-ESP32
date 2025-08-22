# 🌡️ Monitoramento de Temperatura com ESP32 + Spring Boot + Thymeleaf

Projeto completo de automação e IoT que monitora temperatura ambiente com ESP32, envia dados para um backend em Spring Boot e exibe histórico em um painel web.

---

## 🚀 Visão Geral

O sistema realiza:
- Leitura da temperatura com sensor **DHT22**
- Exibição da temperatura em um **display OLED**
- Controle visual com **LEDs** e alerta sonoro com **buzzer**
- Envio dos dados para um backend via **HTTP**
- Armazenamento do histórico em banco **H2**
- Visualização dos dados em tempo real no navegador com **Thymeleaf**

---

## ⚙️ Tecnologias Usadas

### 🔧 Hardware
- ESP32
- Sensor DHT22 (ou DHT11)
- Display OLED I2C (128x64)
- LED verde e vermelho
- Buzzer ativo
- Protoboard, resistores e jumpers

### 💻 Software
- Arduino IDE (com bibliotecas: DHT, SSD1306, GFX, ArduinoJson)
- Spring Boot (Java 17+)
- Banco de dados H2
- Thymeleaf (para frontend HTML)

---

<!--## 🧠 Funcionalidades-->

<!--| Condição | LED Verde | LED Vermelho | Buzzer |-->
<!--|----------|-----------|--------------|--------|-->
<!--| Temp. ≤ 25 °C | ✅ Ligado | ❌ Desligado | ❌ Silencioso |-->
<!--| Temp. > 25 °C | ❌ Desligado | ✅ Ligado | 🔊 Bipe a cada 30 segundos |-->

---

## 📡 Endpoints da API

| Método | Rota         | Descrição                       |
|--------|--------------|----------------------------------|
| POST   | `/temporal`  | Recebe leitura atual (sem salvar) |
| POST   | `/historico` | Salva medição no banco           |
| GET    | `/temporal`  | Retorna última leitura recebida |
| GET    | `/historico` | Retorna lista de medições salvas |
| GET    | `/painel`    | Painel HTML com histórico        |

---

<!--  ## 📺 Interface Web -->

<!--  ![Interface do painel](https://via.placeholder.com/800x400.png?text=Exemplo+Painel+Thymeleaf)  -->
<!--  *Acesse em: [`http://localhost:8080/painel`](http://localhost:8080/painel)* -->

<!-- --- -->

## 🛠️ Como Executar

### ESP32

1. Abra o código no Arduino IDE
2. Ajuste `ssid`, `password` e IP do servidor no código
3. Faça upload para o ESP32
4. Monitore via Serial Monitor

### Spring Boot

```bash
git clone [https://github.com/seunome/esp32-temperatura.git](https://github.com/evandrossjr/Medidor-de-Temperatura-SpringBoot-ESP32)
cd esp32-temperatura
./mvnw spring-boot:run
