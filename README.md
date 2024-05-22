# MyTranslator
## **Artem Rekalov**
#### Тестовое задание для прохождения на стажировку в Kaspersky (направление kotlin/java)

### Было сделано
1. Основной экран с возможностью перевода и историей (при нажатии на item истории, он подставляется в строку поиска)
2. Экран избранного с возможностью перехода к запросу или удаленя

### Стек
- Kotlin
- Android navigation
- Kotlin Coroutines
- Retrofit
- Dagger2
- Room
- ssp, sdp <https://github.com/intuit/sdp> (лучшая адаптация приложения к разным размерам экрана)

### Архитектура
1. App (основная логика приложения)
2. Data (подключение к серверу, POJO)

### Особенности реализации
- Clean Architecture
- MVVM
- Dagger2
- Single Activity
- Навигация с помощью navigation components
- Kotlin Coroutines + LiveData