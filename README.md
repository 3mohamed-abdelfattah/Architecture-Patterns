# Android Architecture Patterns

## MVC (Model-View-Controller)

![MVC](https://github.com/3mohamed-abdelfattah/Architecture-Patterns/assets/142848460/04268530-f377-4a9f-b607-5b75200e5f01)

### Description:
- **Model**: Manages the data and business logic.
- **View**: Displays the data and sends user actions to the Controller.
- **Controller**: Acts as an intermediary between Model and View. It processes user input, interacts with the Model, and updates the View.

### Pros:
- **Separation of concerns**: Divides the application into three interconnected components, making it easier to manage.

### Cons:
- **Tight coupling**: The Controller can become overly complex and tightly coupled with the View, making it hard to maintain and test.
- **Difficult to scale**: As the application grows, the Controller might become a bottleneck.

## MVP (Model-View-Presenter)

![MVP](https://github.com/3mohamed-abdelfattah/Architecture-Patterns/assets/142848460/0fd253bd-ba0f-48d6-a4c8-78a1fa623cab)

### Description:
- **Model**: Manages the data and business logic.
- **View**: Displays data and delegates user interactions to the Presenter.
- **Presenter**: Handles all the presentation logic, interacts with the Model, and updates the View.

### Pros:
- **Better separation of concerns**: The Presenter is responsible for presentation logic, making the View simpler.
- **Testable**: Since the Presenter doesn’t depend on Android framework classes, it’s easier to unit test.

### Cons:
- **Overhead**: Requires more boilerplate code.
- **Maintenance**: For very large projects, managing the Presenter can become cumbersome.

## MVVM (Model-View-ViewModel)

![MVVM](https://github.com/3mohamed-abdelfattah/Architecture-Patterns/assets/142848460/ce94a541-2707-4e89-b1e6-3c1e13c5740b)

### Description:
- **Model**: Manages the data and business logic.
- **View**: Displays data and delegates user interactions to the ViewModel.
- **ViewModel**: Exposes data streams relevant to the View and handles complex logic. It uses data binding to sync with the View.

### Pros:
- **Two-way data binding**: Simplifies the synchronization between the View and the ViewModel.
- **Testability**: The ViewModel doesn’t depend on Android framework classes, making it easy to unit test.
- **Separation of concerns**: Clearly separates the development of the UI from the business logic.

### Cons:
- **Complexity**: Data binding can add complexity and be challenging to debug.
- **Overhead**: More boilerplate code and architectural setup.

### Implementation Example in Kotlin:
To use MVVM architecture with Android's ViewModel, you need the following dependency:

```kotlin
implementation("androidx.activity:activity-ktx:1.9.0")
