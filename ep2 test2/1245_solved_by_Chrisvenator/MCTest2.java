// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?",

                        new Choice(true, "Iterator-Implementierungen bestimmen die Reihenfolge der Iterationen.              (1A)"),
                        new Choice(false, "Eine Collection kann auch mehrere Iterator-Implementierung enthalten.              (1B)"),
                        new Choice(false, "Das Interface Iterable spezifiziert die Methoden next() und hasNext().             (1C)"),
                        new Choice(true, "Iteratoren über Bäumen traversieren Bäume meist rekursiv.                          (1D)"),
                        new Choice(true, "Iteratoren vermeiden das Halten von Kopien der iterierten Daten.                   (1E)")
                ),

                new Question(
                        "int f=44, j=1, k=1; while (k < f) j *= ++k; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(true, "j ist das Produkt aller Zahlen von 1 bis f, also 1*...*f                           (2A)"),
                        new Choice(false, "j ist das Produkt aller Zahlen von 1 bis k, also 1*...*k                           (2B)"),//TODO
                        new Choice(false, "k > 1                                                                              (2C)"),
                        new Choice(false, "j >= f                                                                             (2D)"),
                        new Choice(false, "j <= f                                                                             (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?",

                        new Choice(false, "Das Ergebnis von getMessage() bestimmt den Typ einer Ausnahme.                     (3A)"),
                        new Choice(true, "Alle Ausnahmen sind vom Typ Throwable.                                             (3B)"),
                        new Choice(true, "Nicht abgefangene Ausnahmen beenden das Programm mit einem Stack-Trace.            (3C)"),
                        new Choice(false, "Ausnahmen vom Typ Exception sind unüberprüft (unchecked).                          (3D)"),
                        new Choice(false, "Ausnahmen vom Typ Error müssen abgefangen werden.                                  (3E)")
                ),

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(false, "{true} w = d < y ? d : y; {w >= y}                                                 (4A)"),
                        new Choice(true, "{true} w = d > y ? d : y; {w >= y}                                                 (4B)"),
                        new Choice(true, "{w > -76} while (w > -76) w--; {w > -76}                                           (4C)"),
                        new Choice(false, "{w > 90} if (w > 89) w--; {w > 90}                                                 (4D)"),
                        new Choice(false, "{d <= -76} while (++w < 89) d--; {d < -76}                                         (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?",

                        new Choice(false, "Wiederholte Fehlerkorrektur führt selten zu fehlerfreien Programmen.               (5A)"),
                        new Choice(true, "Schnittstellen-Tests überprüfen die Zusammenarbeit von Modulen.                    (5B)"),
                        new Choice(true, "Fehlerfreiheit wird nur durch intensives Testen garantiert.                        (5C)"),
                        new Choice(true, "Grey-Box-Testen legt Testfälle vor der Implementierung fest.                       (5D)"),
                        new Choice(false, "White-Box-Testen leitet Testfälle aus Anwendungsfällen ab.                         (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Iterator-Implementierungen bestimmen die Reihenfolge der Iterationen.              (1A)\n" +
            "    XXXXXXXXX Eine Collection kann auch mehrere Iterator-Implementierung enthalten.              (1B)\n" +
            "    XXXXXXXXX Das Interface Iterable spezifiziert die Methoden next() und hasNext().             (1C)\n" +
            "    XXXXXXXXX Iteratoren über Bäumen traversieren Bäume meist rekursiv.                          (1D)\n" +
            "    XXXXXXXXX Iteratoren vermeiden das Halten von Kopien der iterierten Daten.                   (1E)\n" +
            "\n" +
            " 2. int f=44, j=1, k=1; while (k < f) j *= ++k; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX j ist das Produkt aller Zahlen von 1 bis f, also 1*...*f                           (2A)\n" +
            "    XXXXXXXXX j ist das Produkt aller Zahlen von 1 bis k, also 1*...*k                           (2B)\n" +
            "    XXXXXXXXX k > 1                                                                              (2C)\n" +
            "    XXXXXXXXX j >= f                                                                             (2D)\n" +
            "    XXXXXXXXX j <= f                                                                             (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Das Ergebnis von getMessage() bestimmt den Typ einer Ausnahme.                     (3A)\n" +
            "    XXXXXXXXX Alle Ausnahmen sind vom Typ Throwable.                                             (3B)\n" +
            "    XXXXXXXXX Nicht abgefangene Ausnahmen beenden das Programm mit einem Stack-Trace.            (3C)\n" +
            "    XXXXXXXXX Ausnahmen vom Typ Exception sind unüberprüft (unchecked).                          (3D)\n" +
            "    XXXXXXXXX Ausnahmen vom Typ Error müssen abgefangen werden.                                  (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {true} w = d < y ? d : y; {w >= y}                                                 (4A)\n" +
            "    XXXXXXXXX {true} w = d > y ? d : y; {w >= y}                                                 (4B)\n" +
            "    XXXXXXXXX {w > -76} while (w > -76) w--; {w > -76}                                           (4C)\n" +
            "    XXXXXXXXX {w > 90} if (w > 89) w--; {w > 90}                                                 (4D)\n" +
            "    XXXXXXXXX {d <= -76} while (++w < 89) d--; {d < -76}                                         (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?\n" +
            "    \n" +
            "    XXXXXXXXX Wiederholte Fehlerkorrektur führt selten zu fehlerfreien Programmen.               (5A)\n" +
            "    XXXXXXXXX Schnittstellen-Tests überprüfen die Zusammenarbeit von Modulen.                    (5B)\n" +
            "    XXXXXXXXX Fehlerfreiheit wird nur durch intensives Testen garantiert.                        (5C)\n" +
            "    XXXXXXXXX Grey-Box-Testen legt Testfälle vor der Implementierung fest.                       (5D)\n" +
            "    XXXXXXXXX White-Box-Testen leitet Testfälle aus Anwendungsfällen ab.                         (5E)\n" +
            "\n";

    public static final long UID = 245176170331560L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}