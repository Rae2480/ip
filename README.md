# Viktor Chatbot User Guide

## Getting Started
### Installation
To use Viktor, ensure you have Java 11 or later installed. Follow these steps:
1. Download `viktor.jar` from the release page.
2. Open a terminal and navigate to the folder containing `viktor.jar`.
3. Run Viktor with:
   ```sh
   java -jar viktor.jar
   ```

### Basic Usage
Once Viktor starts, type a command and press Enter. Viktor will respond accordingly.

## Features
### Task Management
Viktor helps you manage tasks efficiently. You can add, list, mark as done, delete, and search tasks.

#### Commands:
- **Add a ToDo**:
  ```sh
  todo Read a book
  ```
- **Add a Deadline**:
  ```sh
  deadline Submit report /by 2025-02-20 18:00
  ```
- **Add an Event**:
  ```sh
  event Team meeting /from 2025-02-20 14:00 /to 2025-02-20 16:00
  ```
- **List all tasks**:
  ```sh
  list
  ```
- **Mark a task as done**:
  ```sh
  done 1
  ```
- **Delete a task**:
  ```sh
  delete 2
  ```
- **Find a task**:
  ```sh
  find meeting
  ```
- **Update a task**:
  ```sh
  update 3 /desc New description
  ```
- **Change a task’s date/time**:
  ```sh
  update 2 /by 2025-02-22 12:00
  ```
  ```sh
  update 4 /from 2025-02-22 10:00 /to 2025-02-22 12:00
  ```
- **View task details**:
  ```sh
  view 5
  ```
- **Undo last action**:
  ```sh
  undo
  ```
- **Redo last undone action**:
  ```sh
  redo
  ```
- **Clear all tasks**:
  ```sh
  clear
  ```
- **View available commands**:
  ```sh
  help
  ```
- **Exit Viktor**:
  ```sh
  bye
  ```


### Persistent Storage
Viktor saves tasks automatically in `tasks.txt`. If the file is missing or corrupted, Viktor will handle it gracefully.

### Updating Viktor
To update, replace your `viktor.jar` file with the latest version from the release page.

### Troubleshooting
- **Viktor doesn’t start**: Ensure Java 11+ is installed.
- **Tasks not saving**: Check if `tasks.txt` is writable.
- **Command not recognized**: Verify the syntax or use `help`.

This guide helps you quickly start using Viktor and make the most of its features.
