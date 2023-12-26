// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?",

                        new Choice(false, "Auch intensives Testen kann nicht alle Fehler aufdecken.                           (1A)"),
                        new Choice(false, "White-Box-Testen legt Testfälle vor der Implementierung fest.                      (1B)"),
                        new Choice(false, "Schnittstellen-Tests überprüfen die Benutzeroberfläche.                            (1C)"),
                        new Choice(false, "Anwender sind wegen möglicher Verfälschungen nicht einzubeziehen.                  (1D)"),
                        new Choice(false, "Black-Box-Testen legt Testfälle vor der Implementierung fest.                      (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?",

                        new Choice(false, "Lineare Listen sind einfach zu implementieren.                                     (2A)"),
                        new Choice(false, "Absicherung gegen schlechte Datenverteilung kann die Laufzeit erhöhen.             (2B)"),
                        new Choice(false, "Quicksort wird auf Arrays häufiger eingesetzt als Mergesort.                       (2C)"),
                        new Choice(false, "Bei unbekannter Datenverteilung dürfen wir keine Zufallsverteilung annehmen.       (2D)"),
                        new Choice(false, "Hash-Tabellen sind für geordnete Daten ungeeignet.                                 (2E)")
                ),

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(false, "{c == 23} c += 1; {c == 22}                                                        (3A)"),
                        new Choice(false, "{true} c += 1; {c <= 0}                                                            (3B)"),
                        new Choice(false, "{c > -12} while (c > -12) c--; {c > -12}                                           (3C)"),
                        new Choice(false, "{true} c = -12; {c <= -12}                                                         (3D)"),
                        new Choice(false, "{p <= -12} while (++c < 22) p--; {p < -12}                                         (3E)")
                ),

                new Question(
                        "public int median(int[] f) { return f[f.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Nachbedingung: f ist absteigend sortiert.                                          (4A)"),
                        new Choice(false, "Nachbedingung: Halbiert die Länge von f.                                           (4B)"),
                        new Choice(false, "Vorbedingung: Greift auf einen Eintrag von f zu.                                   (4C)"),
                        new Choice(false, "Nachbedingung: f != null                                                           (4D)"),
                        new Choice(false, "Nachbedingung: Wirft eine Exception wenn f.length == 0.                            (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Schleifen und Schleifeninvarianten zu?",

                        new Choice(false, "Fortschritt muss unabhängig von Schleifeninvarianten geprüft werden.               (5A)"),
                        new Choice(false, "Schleifeninvarianten müssen auch vor und nach der Schleife gelten.                 (5B)"),
                        new Choice(false, "Die Schleifenbedingung kann nicht Teil einer Schleifeninvariante sein.             (5C)"),
                        new Choice(false, "Schleifeninvarianten müssen vor jedem Methodenaufruf erfüllt sein.                 (5D)"),
                        new Choice(false, "Schleifeninvarianten sind manchmal durch assert-Anweisungen dargestellt.           (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?\n" +
            "    \n" +
            "    XXXXXXXXX Auch intensives Testen kann nicht alle Fehler aufdecken.                           (1A)\n" +
            "    XXXXXXXXX White-Box-Testen legt Testfälle vor der Implementierung fest.                      (1B)\n" +
            "    XXXXXXXXX Schnittstellen-Tests überprüfen die Benutzeroberfläche.                            (1C)\n" +
            "    XXXXXXXXX Anwender sind wegen möglicher Verfälschungen nicht einzubeziehen.                  (1D)\n" +
            "    XXXXXXXXX Black-Box-Testen legt Testfälle vor der Implementierung fest.                      (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Lineare Listen sind einfach zu implementieren.                                     (2A)\n" +
            "    XXXXXXXXX Absicherung gegen schlechte Datenverteilung kann die Laufzeit erhöhen.             (2B)\n" +
            "    XXXXXXXXX Quicksort wird auf Arrays häufiger eingesetzt als Mergesort.                       (2C)\n" +
            "    XXXXXXXXX Bei unbekannter Datenverteilung dürfen wir keine Zufallsverteilung annehmen.       (2D)\n" +
            "    XXXXXXXXX Hash-Tabellen sind für geordnete Daten ungeeignet.                                 (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {c == 23} c += 1; {c == 22}                                                        (3A)\n" +
            "    XXXXXXXXX {true} c += 1; {c <= 0}                                                            (3B)\n" +
            "    XXXXXXXXX {c > -12} while (c > -12) c--; {c > -12}                                           (3C)\n" +
            "    XXXXXXXXX {true} c = -12; {c <= -12}                                                         (3D)\n" +
            "    XXXXXXXXX {p <= -12} while (++c < 22) p--; {p < -12}                                         (3E)\n" +
            "\n" +
            " 4. public int median(int[] f) { return f[f.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingung: f ist absteigend sortiert.                                          (4A)\n" +
            "    XXXXXXXXX Nachbedingung: Halbiert die Länge von f.                                           (4B)\n" +
            "    XXXXXXXXX Vorbedingung: Greift auf einen Eintrag von f zu.                                   (4C)\n" +
            "    XXXXXXXXX Nachbedingung: f != null                                                           (4D)\n" +
            "    XXXXXXXXX Nachbedingung: Wirft eine Exception wenn f.length == 0.                            (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf Schleifen und Schleifeninvarianten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Fortschritt muss unabhängig von Schleifeninvarianten geprüft werden.               (5A)\n" +
            "    XXXXXXXXX Schleifeninvarianten müssen auch vor und nach der Schleife gelten.                 (5B)\n" +
            "    XXXXXXXXX Die Schleifenbedingung kann nicht Teil einer Schleifeninvariante sein.             (5C)\n" +
            "    XXXXXXXXX Schleifeninvarianten müssen vor jedem Methodenaufruf erfüllt sein.                 (5D)\n" +
            "    XXXXXXXXX Schleifeninvarianten sind manchmal durch assert-Anweisungen dargestellt.           (5E)\n" +
            "\n";

    public static final long UID = 245286083322618L;

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