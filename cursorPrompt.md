**Prompt for Cursor AI IDE:**

Title: **Kotlin Multiplatform Web3 NFT Viewer and Minting App**

Purpose: This is a Kotlin Multiplatform app for Android and iOS that allows users to view NFTs linked to their email and scan QR codes to initiate the minting process for special events. The app interacts with a backend API that is already implemented, leveraging AWS for blockchain-related processes. The user provides their email, and the app fetches associated NFTs via an API. Additionally, the app can scan a QR code and pass it, along with the user’s email, to an endpoint to begin the minting process.

---

### App Features:
1. **Home Screen**:
    - User inputs their email.
    - Email should be validated (basic format check).
    - Submit button triggers API call to fetch NFTs linked to the email.
    - After the API call succeeds, navigate to the list of events.

2. **Events List Page**:
    - Display a list of events the user has NFTs from.
    - Each item in the list represents an event where the user minted an NFT.
    - When the user clicks an event, navigate to a page showing the event’s associated metadata (fetched via another API call).

3. **NFT Metadata Page**:
    - Display details such as event name, date, NFT description, and other relevant metadata.
    - Back button to return to the events list.

4. **QR Code Scanner**:
    - A page with a QR code scanner.
    - When a QR code is scanned, the app extracts the information (e.g., event ID or minting URL).
    - Trigger an API call to start the minting process, passing the scanned QR data along with the user’s email.
    - Provide feedback on success or failure of the minting process (e.g., toast or dialog).

### API Interaction:
- The backend already exposes API endpoints for:
    1. **Fetch NFTs by email**: An endpoint that accepts a user’s email and returns a list of NFTs and events they’re associated with.
    2. **Fetch metadata for an event/NFT**: An endpoint to get detailed metadata about a specific NFT event.
    3. **Start minting process**: An endpoint that initiates the minting of an NFT based on a QR code scan. It requires the event ID (from QR) and the user’s email.

---

### Technical Details:
1. **Kotlin Multiplatform Setup**:
    - Set up a Kotlin Multiplatform project using the **Kotlin Multiplatform Mobile wizard**.
    - Create shared code for handling API requests using Ktor or any preferred HTTP client.
    - Use Kotlinx Serialization for serializing and deserializing data.
    - Implement platform-specific code for the QR scanner using platform-specific libraries:
        - For Android: Use the `ML Kit` or `Zxing` library.
        - For iOS: Use `AVFoundation` framework for scanning QR codes.

2. **UI Implementation**:
    - Use Jetpack Compose for Android and SwiftUI for iOS, or KMP libraries like `Multiplatform Compose` for shared UI across both platforms.
    - **Home Screen**: A simple form with an email input field, submit button, and basic email validation.
    - **Event List Page**: A list view (LazyColumn in Jetpack Compose) showing NFT events.
    - **NFT Metadata Page**: A detailed view showing NFT metadata with a back button.
    - **QR Scanner**: Use the respective platform libraries (ML Kit/Zxing for Android and AVFoundation for iOS) to implement a camera-based QR code scanner.

3. **API Calls**:
    - Shared code for API interaction. Use **Ktor** for making HTTP requests in a shared module. Handle:
        - Fetching NFTs by email.
        - Fetching event metadata.
        - Starting the minting process after scanning a QR code.

4. **State Management**:
    - Use **StateFlow** or **LiveData** for managing app state and UI updates.
    - Ensure proper error handling (e.g., network errors, invalid responses).

5. **Dependency Management**:
    - For dependency injection, consider using **Koin** or **Dagger Hilt** (Hilt for Android, Koin for shared code).
    - For navigation, consider using **Compose Navigation** for Android and SwiftUI’s built-in navigation on iOS.

---

### API Details:
1. **GET /nfts?email={email}**: Returns a list of NFT events associated with the user’s email.
    - Request: `{ "email": "user@example.com" }`
    - Response: A list of events with each event containing:
        - Event ID
        - Event name
        - NFT metadata

2. **GET /nft/{eventId}/metadata**: Returns metadata about a specific NFT.
    - Request: `{ "eventId": "12345" }`
    - Response: `{ "eventName": "Event Name", "date": "2024-01-01", "description": "Event Description", ... }`

3. **POST /mint**: Starts the minting process for a specific event.
    - Request: `{ "email": "user@example.com", "eventId": "12345" }`
    - Response: `{ "status": "success", "message": "Minting started" }`

---

### Required Libraries:
- **Ktor** for API calls
- **Kotlinx Serialization** for handling JSON
- **Jetpack Compose** (Android) or **SwiftUI** (iOS)
- **ML Kit / Zxing** (Android) or **AVFoundation** (iOS) for QR code scanning
- **StateFlow** or **LiveData** for state management
- **Koin / Dagger Hilt** for dependency injection

---