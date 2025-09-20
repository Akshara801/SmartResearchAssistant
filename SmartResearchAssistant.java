import java.util.*;

public class SmartResearchAssistant {

    // Simulated local document database
    private static final Map<String, String> localDocs = new HashMap<>();

    // Simulated live internet sources
    private static final Map<String, String> liveSources = new HashMap<>();

    static {
        // Preload some local "documents"
        localDocs.put("AI", "AI improves efficiency in research by automating data collection. [LocalDoc1]");
        localDocs.put("ML", "Machine Learning models can predict outcomes based on past data. [LocalDoc2]");
        localDocs.put("startup", "Startups face high failure rates due to market uncertainty. [LocalDoc3]");

        // Preload some live "sources"
        liveSources.put("AI", "AI is rapidly evolving with new models being released every year. [LiveBlog]");
        liveSources.put("ML", "ML adoption is growing across industries in 2025. [TechNews]");
        liveSources.put("startup", "Funding for startups has increased in 2025 with AI-driven innovation. [MarketWatch]");
    }

    // Function to search for answers
    private static List<String> search(String query) {
        List<String> results = new ArrayList<>();

        for (Map.Entry<String, String> entry : localDocs.entrySet()) {
            if (query.toLowerCase().contains(entry.getKey().toLowerCase())) {
                results.add("Local: " + entry.getValue());
            }
        }

        for (Map.Entry<String, String> entry : liveSources.entrySet()) {
            if (query.toLowerCase().contains(entry.getKey().toLowerCase())) {
                results.add("Live: " + entry.getValue());
            }
        }

        if (results.isEmpty()) {
            results.add("No direct match found. Try refining your query.");
        }

        return results;
    }

    // Function to generate a report
    private static void generateReport(String query, List<String> results) {
        System.out.println("\n===== Research Report =====");
        System.out.println("Query: " + query);
        System.out.println("----------------------------");
        for (String result : results) {
            System.out.println("- " + result);
        }
        System.out.println("============================\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to Smart Research Assistant ===");

        while (true) {
            System.out.print("\nEnter your research query (or type 'exit' to quit): ");
            String query = scanner.nextLine();

            if (query.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Smart Research Assistant. Goodbye!");
                break;
            }

            List<String> results = search(query);
            generateReport(query, results);
        }

        scanner.close();
    }
}
