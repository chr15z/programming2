// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "int f=95, r=1, i=1; while (i < f) r *= ++i; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(true, "r ist das Produkt aller Zahlen von 1 bis f, also 1*...*f                           (1A)"),
                        new Choice(true, "i >= 1 && i <= f                                                                   (1B)"),
                        new Choice(true, "i > 1                                                                              (1C)"),
                        new Choice(true, "i >= 1 && i <= 95                                                                  (1D)"),
                        new Choice(false, "i > 0 && i < f                                                                     (1E)")
                ),

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(false, "{d <= -35} while (++n < 39) d--; {d < -35}                                         (2A)"),
                        new Choice(true, "{true} n = d > c ? d : c; {n >= d}                                                 (2B)"),
                        new Choice(false, "{n == 40} n++; {n == 39}                                                           (2C)"),
                        new Choice(false, "{true} n++; {n <= 0}                                                               (2D)"),
                        new Choice(false, "{n > -35} while (n > -35) n--; {n > -35}                                           (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?",

                        new Choice(true, "Black-Box-Testen leitet Testfälle aus Anwendungsfällen ab.                         (3A)"),
                        new Choice(true, "Mit absichtlichen Fehlern ist die Qualität des Testens prüfbar.                    (3B)"),
                        new Choice(false, "Regressions-Tests müssen fast immer händisch durchgeführt werden.                  (3C)"),
                        new Choice(false, "Wiederholte Fehlerkorrektur führt rasch zu fehlerfreien Programmen.                (3D)"),
                        new Choice(false, "Fehlerfreiheit wird nur durch intensives Testen garantiert.                        (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                        "Java-Collections-Framework zu?",

                        new Choice(false, "TreeSet<E> ist Untertyp von SortedMap<K,V>.                                        (4A)"),
                        new Choice(false, "LinkedList<E> ist Untertyp von TreeSet<E>                                          (4B)"),
                        new Choice(false, "TreeSet<E> erlaubt mehrere gleiche Einträge.                                       (4C)"),
                        new Choice(false, "Queue<E> erweitert Collection<E> um zusätzliche Methoden.                          (4D)"),
                        new Choice(true, "LinkedHashSet<E> implementiert Set<E>.                                             (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?",

                        new Choice(false, "Ausnahmen vom Typ Error werden meist abgefangen.                                   (5A)"),
                        new Choice(false, "Ausnahmen vom Typ NullPointerException sind unüberprüft (unchecked).               (5B)"),
                        new Choice(true, "Das Ergebnis von getMessage() soll die Fehlerart konkretisieren.                   (5C)"),
                        new Choice(true, "Alle Ausnahmen sind vom Typ Throwable.                                             (5D)"),
                        new Choice(false, "Auch ohne Programmabbruch kann ein Stack-Trace ausgegeben werden.                  (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. int f=95, r=1, i=1; while (i < f) r *= ++i; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX r ist das Produkt aller Zahlen von 1 bis f, also 1*...*f                           (1A)\n" +
            "    XXXXXXXXX i >= 1 && i <= f                                                                   (1B)\n" +
            "    XXXXXXXXX i > 1                                                                              (1C)\n" +
            "    XXXXXXXXX i >= 1 && i <= 95                                                                  (1D)\n" +
            "    XXXXXXXXX i > 0 && i < f                                                                     (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {d <= -35} while (++n < 39) d--; {d < -35}                                         (2A)\n" +
            "    XXXXXXXXX {true} n = d > c ? d : c; {n >= d}                                                 (2B)\n" +
            "    XXXXXXXXX {n == 40} n++; {n == 39}                                                           (2C)\n" +
            "    XXXXXXXXX {true} n++; {n <= 0}                                                               (2D)\n" +
            "    XXXXXXXXX {n > -35} while (n > -35) n--; {n > -35}                                           (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?\n" +
            "    \n" +
            "    XXXXXXXXX Black-Box-Testen leitet Testfälle aus Anwendungsfällen ab.                         (3A)\n" +
            "    XXXXXXXXX Mit absichtlichen Fehlern ist die Qualität des Testens prüfbar.                    (3B)\n" +
            "    XXXXXXXXX Regressions-Tests müssen fast immer händisch durchgeführt werden.                  (3C)\n" +
            "    XXXXXXXXX Wiederholte Fehlerkorrektur führt rasch zu fehlerfreien Programmen.                (3D)\n" +
            "    XXXXXXXXX Fehlerfreiheit wird nur durch intensives Testen garantiert.                        (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
            "    Java-Collections-Framework zu?\n" +
            "    \n" +
            "    XXXXXXXXX TreeSet<E> ist Untertyp von SortedMap<K,V>.                                        (4A)\n" +
            "    XXXXXXXXX LinkedList<E> ist Untertyp von TreeSet<E>                                          (4B)\n" +
            "    XXXXXXXXX TreeSet<E> erlaubt mehrere gleiche Einträge.                                       (4C)\n" +
            "    XXXXXXXXX Queue<E> erweitert Collection<E> um zusätzliche Methoden.                          (4D)\n" +
            "    XXXXXXXXX LinkedHashSet<E> implementiert Set<E>.                                             (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Ausnahmen vom Typ Error werden meist abgefangen.                                   (5A)\n" +
            "    XXXXXXXXX Ausnahmen vom Typ NullPointerException sind unüberprüft (unchecked).               (5B)\n" +
            "    XXXXXXXXX Das Ergebnis von getMessage() soll die Fehlerart konkretisieren.                   (5C)\n" +
            "    XXXXXXXXX Alle Ausnahmen sind vom Typ Throwable.                                             (5D)\n" +
            "    XXXXXXXXX Auch ohne Programmabbruch kann ein Stack-Trace ausgegeben werden.                  (5E)\n" +
            "\n";

    public static final long UID = 247303703884224L;

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