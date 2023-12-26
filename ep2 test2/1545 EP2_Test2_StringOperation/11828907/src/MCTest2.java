// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(false, "{e > -56} if (e > -57) e--; {e > -56}                                              (1A)"),
                        new Choice(true, "{e == -57} e += 1; {e == -56}                                                      (1B)"),
                        new Choice(false, "{e > -70} while (e > -70) e--; {e > -70}                                           (1C)"),
                        new Choice(true, "{e > -56} if (e < -57) e--; {e > -56}                                              (1D)"),
                        new Choice(true, "{q < -57} while (++q <= -57) e--; {q > -57}                                        (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?",

                        new Choice(true, "Unzureichende Prüfung kann z.B. zu einer SQL-Injection führen.                     (2A)"),
                        new Choice(false, "Die Validierung soll erst möglichst knapp vor der Ausgabe erfolgen.                (2B)"),
                        new Choice(true, "Von außen kommende Daten sind zu prüfen, nicht intern weitergereichte.             (2C)"),
                        new Choice(true, "Alle Daten von außerhalb des Programms müssen überprüft werden.                    (2D)"),
                        new Choice(true, "Reparaturversuche nicht plausibler Daten können gefährlich sein.                   (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                        "Java-Collections-Framework zu?",

                        new Choice(true, "List<E> erweitert Collection<E> um zusätzliche Methoden.                           (3A)"),
                        new Choice(true, "LinkedList<E> ist Untertyp von Collection<E>                                       (3B)"),
                        new Choice(false, "HashSet<E> erlaubt mehrere gleiche Einträge.                                       (3C)"),
                        new Choice(false, "In eine Queue<E> kann man neben offer auch mittels peek einfügen.                  (3D)"),
                        new Choice(false, "LinkedHashMap<K,V> ist eine lineare Liste, die Hashtabellen enthält.               (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?",

                        new Choice(true, "Auch intensives Testen kann nicht alle Fehler aufdecken.                           (4A)"),
                        new Choice(true, "Wiederholte Fehlerkorrektur führt selten zu fehlerfreien Programmen.               (4B)"),
                        new Choice(false, "Schnittstellen-Tests überprüfen die Benutzeroberfläche.                            (4C)"),
                        new Choice(false, "Anwender sind wegen möglicher Verfälschungen nicht einzubeziehen.                  (4D)"),
                        new Choice(true, "White-Box-Testen leitet Testfälle aus der Implementierung ab.                      (4E)")
                ),

                new Question(
                        "public int median(int[] y) { return y[y.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(true, "Nachbedingung: Gibt y[0] zurück wenn y.length == 1.                                (5A)"),
                        new Choice(false, "Vorbedingung: Greift auf einen Eintrag von y zu.                                   (5B)"),
                        new Choice(true, "Vorbedingung: y != null                                                            (5C)"),
                        new Choice(false, "Nachbedingung: y ist absteigend sortiert.                                          (5D)"),
                        new Choice(true, "Nachbedingung: Wirft eine Exception wenn y == null.                                (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {e > -56} if (e > -57) e--; {e > -56}                                              (1A)\n" +
            "    XXXXXXXXX {e == -57} e += 1; {e == -56}                                                      (1B)\n" +
            "    XXXXXXXXX {e > -70} while (e > -70) e--; {e > -70}                                           (1C)\n" +
            "    XXXXXXXXX {e > -56} if (e < -57) e--; {e > -56}                                              (1D)\n" +
            "    XXXXXXXXX {q < -57} while (++q <= -57) e--; {q > -57}                                        (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Unzureichende Prüfung kann z.B. zu einer SQL-Injection führen.                     (2A)\n" +
            "    XXXXXXXXX Die Validierung soll erst möglichst knapp vor der Ausgabe erfolgen.                (2B)\n" +
            "    XXXXXXXXX Von außen kommende Daten sind zu prüfen, nicht intern weitergereichte.             (2C)\n" +
            "    XXXXXXXXX Alle Daten von außerhalb des Programms müssen überprüft werden.                    (2D)\n" +
            "    XXXXXXXXX Reparaturversuche nicht plausibler Daten können gefährlich sein.                   (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
            "    Java-Collections-Framework zu?\n" +
            "    \n" +
            "    XXXXXXXXX List<E> erweitert Collection<E> um zusätzliche Methoden.                           (3A)\n" +
            "    XXXXXXXXX LinkedList<E> ist Untertyp von Collection<E>                                       (3B)\n" +
            "    XXXXXXXXX HashSet<E> erlaubt mehrere gleiche Einträge.                                       (3C)\n" +
            "    XXXXXXXXX In eine Queue<E> kann man neben offer auch mittels peek einfügen.                  (3D)\n" +
            "    XXXXXXXXX LinkedHashMap<K,V> ist eine lineare Liste, die Hashtabellen enthält.               (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?\n" +
            "    \n" +
            "    XXXXXXXXX Auch intensives Testen kann nicht alle Fehler aufdecken.                           (4A)\n" +
            "    XXXXXXXXX Wiederholte Fehlerkorrektur führt selten zu fehlerfreien Programmen.               (4B)\n" +
            "    XXXXXXXXX Schnittstellen-Tests überprüfen die Benutzeroberfläche.                            (4C)\n" +
            "    XXXXXXXXX Anwender sind wegen möglicher Verfälschungen nicht einzubeziehen.                  (4D)\n" +
            "    XXXXXXXXX White-Box-Testen leitet Testfälle aus der Implementierung ab.                      (4E)\n" +
            "\n" +
            " 5. public int median(int[] y) { return y[y.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingung: Gibt y[0] zurück wenn y.length == 1.                                (5A)\n" +
            "    XXXXXXXXX Vorbedingung: Greift auf einen Eintrag von y zu.                                   (5B)\n" +
            "    XXXXXXXXX Vorbedingung: y != null                                                            (5C)\n" +
            "    XXXXXXXXX Nachbedingung: y ist absteigend sortiert.                                          (5D)\n" +
            "    XXXXXXXXX Nachbedingung: Wirft eine Exception wenn y == null.                                (5E)\n" +
            "\n";

    public static final long UID = 239306193505782L;

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