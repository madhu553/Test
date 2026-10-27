--
name: 'Layered Application & Packaging Instructions'
description: 'This file describes the layered application and packaging instructions for all java files.'
applyTo: '**/*.java'
---

# Layered Application & Packaging

## 1. Architecture

The application follows a **3-layer architecture**:

1. **Controller** - Entry-level/API logic. All `@RestController` classes belong here.
   - The Controller layer can call the Service layer **only through Service interfaces**.
2. **Service** - Core business logic belongs here.
   - The Service layer can call the Repository layer **only through Repository interfaces**.
3. **Repository** - Database access and persistence logic belongs here.