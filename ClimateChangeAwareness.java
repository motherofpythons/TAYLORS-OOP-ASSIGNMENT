import java.util.Scanner; // Import Scanner class to read input from the user
import java.io.BufferedWriter; // Import BufferedWriter to write to files
import java.io.FileWriter; // Import FileWriter to open files for writing
import java.io.IOException; // Import IOException to handle file-related errors
import java.time.LocalDate; // Import LocalDate to get the current date

public class ClimateChangeAwareness {

    // Welcome message: Prints a friendly greeting and intro to the program
    public static void welcomeMessage() {
        System.out.println("Welcome to the Climate Change Awareness Program!");
        System.out.println("Learn how climate change is affecting our planet and how you can help!");
        printSeparator(); // Call printSeparator to visually separate the sections
    }

    public static void printSeparator() {
        System.out.println("-----------------------------------------");
    }

    // Display information based on user choice: This function displays information depending on the option selected by the user
    public static void display_info(int choice) {
        switch (choice) { // Switch case handles different user choices
            case 1:
                System.out.println("What is the impact of climate change?");
                display_impact_info(); // Calls display_impact_info for detailed information
                break;
            case 2:
                System.out.println("How does carbon footprint affect the environment?");
                display_carbon_footprint_info(); // Calls display_carbon_footprint_info for detailed information
                break;
            case 3:
                System.out.println("What can you do to reduce your carbon footprint?");
                display_reduction_tips(); // Calls display_reduction_tips for practical steps
                break;
            case 4:
                System.out.println("What is global warming?");
                display_global_warming_info(); // Calls display_global_warming_info to explain global warming
                break;
            case 5:
                System.out.println("How can you help the environment?");
                display_help_environment_info(); // Calls display_help_environment_info for actionable tips
                break;
            case 6:
                System.out.println("What is the greenhouse effect?");
                display_greenhouse_effect_info(); // Calls display_greenhouse_effect_info to explain the greenhouse effect
                break;
            default:
                System.out.println("Invalid option."); // This is for invalid options outside the menu
        }
    }

    // Display impact information: Provides information on the impact of climate change
    public static void display_impact_info() {
        System.out.println("1. Climate change causes extreme weather events such as hurricanes and droughts.");
        System.out.println("2. Rising temperatures cause glaciers to melt, raising sea levels.");
        System.out.println("3. It impacts agriculture, causing crop failures.");
        printSeparator(); // Adds separator line for clarity
    }

    // Display carbon footprint information: Explains what carbon footprints are and their significance
    public static void display_carbon_footprint_info() {
        System.out.println("A carbon footprint represents the total greenhouse gases emitted by human activities.");
        System.out.println("Every individual and company contributes to the carbon footprint.");
        printSeparator(); // Adds separator line for clarity
    }

    // Display tips for reducing carbon footprint: Suggests actions to help reduce a person's carbon footprint
    public static void display_reduction_tips() {
        System.out.println("1. Use energy-efficient appliances.");
        System.out.println("2. Reduce waste and recycle.");
        System.out.println("3. Use public transport or carpool.");
        printSeparator(); // Adds separator line for clarity
    }

    // New information on global warming: Provides an explanation of what global warming is and how it happens
    public static void display_global_warming_info() {
        System.out.println("Global warming refers to the long-term heating of Earth’s climate system due to human activities.");
        System.out.println("It is primarily caused by the release of greenhouse gases such as carbon dioxide.");
        printSeparator(); // Adds separator line for clarity
    }

    // New information on how users can help the environment: Offers suggestions for practical actions that individuals can take
    public static void display_help_environment_info() {
        System.out.println("You can help the environment by reducing waste, conserving water, and using renewable energy.");
        System.out.println("Small actions like planting trees and using less plastic can make a big difference!");
        printSeparator(); // Adds separator line for clarity
    }

    // New information on the greenhouse effect: Explains the greenhouse effect and its role in global warming
    public static void display_greenhouse_effect_info() {
        System.out.println("The greenhouse effect is the process by which greenhouse gases trap heat in the Earth's atmosphere.");
        System.out.println("It is essential for life on Earth, but human activities have intensified this effect, leading to global warming.");
        printSeparator(); // Adds separator line for clarity
    }

    // Log user selection: This function logs the user's choice and the current date to a text file for record-keeping
    public static void log_info(int choice) {
        try {
            // Create BufferedWriter to write to "ClimateAwareness.txt" file in append mode
            BufferedWriter writer = new BufferedWriter(new FileWriter("ClimateAwareness.txt", true)); 
            LocalDate current_date = LocalDate.now(); // Get current date
            writer.write("\nDate: " + current_date + "\n"); // Write date to file
            writer.write("User selected option: " + choice + "\n"); // Log the user's choice
            writer.write("--------------------------------------------------------------\n"); // Separator line for readability
            writer.close(); // Close the writer to save the data
        } catch (IOException e) { // Handle any potential file I/O errors
            e.printStackTrace();
        }
    }

    // Main method: This is the entry point where the program starts. It controls the program's flow.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create a Scanner object to read user input
        int choice; // Variable to store the user's menu choice
        int count = 0; // Track number of topics learned

        welcomeMessage(); // Call welcomeMessage to display the introductory message

        do {
            // Display the menu of options to the user
            System.out.println("Select an option to learn about Climate Change Impact:");
            System.out.println("1. What is the impact of climate change?");
            System.out.println("2. How does carbon footprint affect the environment?");
            System.out.println("3. What can you do to reduce your carbon footprint?");
            System.out.println("4. What is global warming?");
            System.out.println("5. How can you help the environment?");
            System.out.println("6. What is the greenhouse effect?");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            choice = in.nextInt(); // Read the user's choice
            if (choice != 7) { // If the user didn't choose "Exit"
                display_info(choice); // Display information based on the user's choice
                log_info(choice); // Log the user's selection to the file
                count++; // Increment the count of topics learned
            }
        } while (choice != 7); // Repeat the menu until the user selects "Exit"

        trackProgress(count); // After the loop ends, call trackProgress to display how many topics the user learned
        System.out.println("Exiting the program..."); // Inform the user that the program is exiting
        in.close(); // Close the Scanner object to prevent resource leakage
    }

    // Track user's progress: This function shows the number of topics the user has explored during the session
    public static void trackProgress(int count) {
        System.out.println("You have learned " + count + " topics today."); // Display the user's progress
    }
}
