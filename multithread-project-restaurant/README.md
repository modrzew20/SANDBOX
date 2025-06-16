# Multithreaded Restaurant Simulation

This project simulates a restaurant operation using Java multithreading concepts. It models a restaurant with limited seating capacity, waiters, and a chef, all working concurrently to serve customers.

## Overview

The simulation uses various Java concurrency tools and design patterns:
- **Chain of Responsibility Pattern**: Handles the customer journey through the restaurant
- **Thread Pool**: Manages waiter resources
- **Semaphores**: Controls access to limited resources (seats)
- **Multithreading**: Simulates multiple customers arriving concurrently

## Components

- **Customer**: Represents a person visiting the restaurant
- **Waiter**: Serves customers (limited resource)
- **Chef**: Prepares meals
- **WaiterPool**: Manages the pool of available waiters
- **Chain Handlers**:
    - WaitingForSeatHandler: Manages seating availability
    - OrderHandler: Processes customer orders
    - ChefHandler: Coordinates meal preparation
    - LeaveHandler: Handles customer departure

## How It Works

1. Customers arrive at random intervals
2. They wait for an available seat (controlled by a semaphore)
3. A waiter from the pool seats them and takes their order
4. The chef prepares the meal
5. The customer eats and leaves, freeing up the seat

## Running the Application

```
mvn clean compile exec:java -Dexec.mainClass="dm.sandbox.Restaurant"
```

## Thread Safety Considerations

- **Semaphores** ensure that the restaurant doesn't exceed seating capacity
- **BlockingQueue** in the WaiterPool manages concurrent access to waiters
- **Chain of Responsibility** pattern separates concerns and maintains thread safety

## Future Improvements

- Add meal selection functionality
- Implement different preparation times for various meals
- Add statistics collection for restaurant performance