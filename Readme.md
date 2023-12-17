# Pharmacy Android Application

This Android application is developed as an academic project for ESPRIT/Mobile Development(Android/Java). It is designed for managing pharmacy-related operations and implements CRUD (Create, Read, Update, Delete) operations on a Room Database. The project includes features such as user authentication, medication management, and patient records.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Features

1. **User Authentication**
   - Sign up: Users can create new accounts with a unique username and password.
   - Sign in: Existing users can log in securely.

2. **User Management**
   - CRUD operations for user accounts.

3. **Medication Management**
   - CRUD operations for adding, updating, and deleting medication records.
   - Medication details include name, dosage, expiry date, etc.

4. **Patient Management**
   - CRUD operations for managing patient records.
   - Patient details include name, contact information, medical history, etc.

5. **Room Database Integration**
   - Utilizes the Room Persistence Library for local database management.

## Technologies Used

- Java
- Android SDK
- Room Persistence Library
- XML (for UI design)

## Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/kvrae/Mobile-Exemple-Java-Android.git
   cd pharmacy-android-app
   ```

2. **Open in Android Studio:**
   - Open Android Studio.
   - Choose "Open an existing Android Studio project" and select the cloned repository.

3. **Build and Run:**
   - Build and run the application on an Android emulator or a physical device.

## Usage

1. **Sign Up / Sign In:**
   - Use the provided authentication screens to sign up or sign in.

2. **Medication Management:**
   - Navigate to the medication section to perform CRUD operations on medication records.

3. **Patient Management:**
   - Navigate to the patient section to perform CRUD operations on patient records.

## Project Structure

- **`app/src/main/java/com/esprit/pharmacy/`**
  - `ui`: Contains activities and fragments for the user interface.
  - `data`: Includes classes for database access and data entities.
  - `utils`: Utility classes.
  - [Other relevant packages]

- **`app/src/main/res/`**
  - `layout`: XML layout files for UI design.
  - [Other relevant resource directories]

## Contributing

If you'd like to contribute to this project, please follow the [contribution guidelines](CONTRIBUTING.md).

## License

This project is licensed under the MIT LICENSE - see the [LICENSE.md](LICENSE.md) file for details.
