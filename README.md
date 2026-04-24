## Airport Management System 

## 📋  PROJECT OVERVIEW
A comprehensive Object-Oriented Airport Management System developed in Java that manages flights, passengers, staff, bookings, security checks, and airport operations. The system demonstrates advanced OOP principles with a scalable and maintainable architecture.

## 🎯 KEY FEATURES
Flight Management - Domestic, International, Cargo, Charter, and Emergency flights
Passenger Booking - Complete reservation and ticketing system
Payment Processing - Multiple payment methods with receipt generation
Security System - Passenger security checks and validation
Baggage Handling - Weight tracking and management
Staff Management - Pilots, cabin crew, ground staff, security officers
Report Generation - Daily flights, passenger statistics, revenue reports
Input Validation - Comprehensive validation with error handling

## 🏗️ OOP PRINCIPLES DEMONSTRATED
Principle	Implementation
Encapsulation	Private attributes with public getters/setters
Inheritance	Flight → 5 subclasses, Staff → 5 subclasses
Polymorphism	Method overriding, Factory pattern
Abstraction	AirportEntity abstract class (10+ abstract methods)
Interfaces	Reservable, Payable, Trackable
## 📁 CLASS STRUCTURE
text
29 Total Classes
├── 1 Abstract Class (AirportEntity)
├── 3 Interfaces (Reservable, Payable, Trackable)
├── 10 Subclasses (Flight & Staff hierarchies)
├── 15 Supporting Classes
└── 1 Main Class (AirportSystem)
## 🚀 CORE COMPONENTS
Flight Types
DomesticFlight - Regional travel with area codes

InternationalFlight - Cross-border with passport/visa requirements

CargoFlight - Freight transport with weight limits

CharterFlight - Private client luxury travel

EmergencyFlight - Priority medical/emergency responses

Staff Roles
Pilot - Flight hours tracking

CabinCrew - Language skills management

GroundStaff - Department assignments

SecurityOfficer - Security clearance levels

MaintenanceStaff - Technical specializations

Booking Flow
text
Passenger Input → Flight Selection → Reservation → 
Payment Processing → Ticket Generation → Boarding Pass → 
Security Check → Baggage Check-in → Notification

## 🛡️ VALIDATION SYSTEM
The InputValidator class handles:

✅ Empty input detection

✅ Passport number format (6-12 alphanumeric)

✅ Flight ID format (AA123 pattern)

✅ Seat number validation (A1, B12, etc.)

✅ Overbooking prevention

✅ Duplicate entry detection

✅ Negative value rejection

## 🎨 DESIGN PATTERNS
Pattern	Usage
Factory Pattern	FlightFactory creates flight objects dynamically
Template Method	Abstract methods in AirportEntity
Strategy Pattern	Different flight booking strategies

## 📊 REPORT TYPES
Daily Flights Report - All scheduled flights with times
Passenger Statistics - Counts and averages
Revenue Report - Total income by payment type
Delays Report - Flight schedule deviations

## 💻 TECHNICAL REQUIREMENTS
Java Version: 8 or higher
Dependencies: None (pure Java)
Input/Output: Console-based interaction
Date/Time: Java Time API (LocalDateTime)

## 🔧 HOW TO RUN
bash
# Compile all Java files
javac AirportSystem.java

# Run the application
java AirportSystem

## 📝 SAMPLE INPUT FORMATS
text
Passport Number: AB123456 (6-12 chars, letters & numbers)
Flight ID: DA101 (2-3 letters + 3-4 digits)
Seat Number: A1, B12, F5 (Letter + 1-2 digits)
Phone Number: +1234567890 (any format accepted)

## 🔄 SYSTEM WORKFLOW
text
START
  ↓
Display Main Menu
  ↓
[1] Book Flight → Get Passenger Details → Select Flight → 
  → Create Reservation → Process Payment → Generate Ticket →
  → Generate Boarding Pass → Send Notification
  ↓
[2] View Flights → Display all available flights with capacity
  ↓
[3] View Passengers → List all registered passengers
  ↓
[4] Generate Reports → Show statistics and analytics
  ↓
[5] Manage Staff → Add/update staff members
  ↓
[6] Manage Baggage → Check-in passenger luggage
  ↓
[7] Security Check → Process passenger security clearance
  ↓
[8] Exit → Terminate system

## 🎯 KEY METHODS BY CLASS
AirportEntity (Abstract)
validateEntity() - Check object validity

activateEntity() / deactivateEntity() - Status management

generateReport() - Create entity report

logActivity() - Audit trail

Flight & Subclasses
calculateFlightDuration() - Time difference calculation

bookPassenger() - Seat reservation with capacity check

Ticket
calculateTicketPrice() - Dynamic pricing by class (Economy/Business/First)

generateTicketDetails() - Formatted ticket output

Payment
processPayment() - Transaction handling

generateReceipt() - Payment confirmation

## 📈 ERROR HANDLING
The system provides meaningful error messages for:

Invalid data type entry

Capacity exceeded

Format violations

Empty required fields

Duplicate IDs

Invalid flight selection

## 🔐 SECURITY FEATURES
Passenger identity validation

Security check clearance process

Passport number verification

Staff role-based access (extensible)

## 🧪 TESTING SCENARIOS
Normal Flow: Complete booking with valid data

Validation: Enter invalid passport/flight ID formats

Overbooking: Try booking full flight

Payment: Different payment methods

Security: Failed security check simulation

## 📦 EXTENSIBILITY
Easy to add:

New flight types (extend Flight class)
New staff roles (extend Staff class)
Additional report types (extend ReportGenerator)
New validation rules (extend InputValidator)

Database persistence (add DAO layer)

GUI interface (separate from business logic)

## 📚 LEARNING OUTCOMES
This project demonstrates:

Complete OOP implementation in real-world scenario

Interface-driven design

Abstract class usage with concrete implementations

Inheritance hierarchies with meaningful overrides

Factory pattern for object creation

Comprehensive input validation strategy

Modular, maintainable code structure
