# Travel Booking System

This project utilizes **Strategy Design Pattern**, a type of Behavioral Design Pattern which allows different booking strategies based on the type of travel (economy, luxury, or business).

## Implementation

- **Context**: The TravelContext class serves as the context that uses a TravelStrategy to book trips.
- **Strategy Interface**: The TravelStrategy interface defines a method bookTrip() for booking trips to different destinations.
- **Strategies**:
  - EconomyTravel
  - LuxuryTravel
  - BusinessTravel

## How to run

1. Clone the repository:
   ```bash
   git clone https://github.com/HariprasathSivakumaar/EI-Study-Assignment.git
   ```
2. Change directory:
   ```bash
   cd EI-Study-Assignment\Exercise 1\Behavioural Design Patterns\Case 2
   ```
3. Run:
   ```bash
   java App
   ```
