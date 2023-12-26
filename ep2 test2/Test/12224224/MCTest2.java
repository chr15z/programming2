// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                        "Java-Collections-Framework zu?",

                        new Choice(false, "Aus einer Queue<E> kann man Elemente mittels poll und remove löschen.              (1A)"),
                        new Choice(false, "Collection<E> erlaubt mehrere gleiche Einträge.                                    (1B)"),
                        new Choice(true, "LinkedList<E> implementiert List<E>.                                               (1C)"),
                        new Choice(false, "TreeSet<E> ist Untertyp von SortedSet<E>.                                          (1D)"),
                        new Choice(true, "LinkedHashMap<K,V> ist eine lineare Liste, die Hashtabellen enthält.               (1E)")
                ),

                new Question(
                        "public int sumFrom1To(int x) { return (x * (x + 1)) / 2; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Vorbedingung: Gibt (x * (x + 1)) / 2 zurück.                                       (2A)"),
                        new Choice(true, "Nachbedingung: Halbiert (x * (x + 1)).                                             (2B)"),
                        new Choice(false, "Vorbedingung: Ergebnis hängt nur von x ab.                                         (2C)"),
                        new Choice(false, "Nachbedingung: Ergebnis ist für x < 1 nicht die Zahlensumme.                       (2D)"),
                        new Choice(true, "Vorbedingung: x > 0.                                                               (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Schleifen und Schleifeninvarianten zu?",

                        new Choice(false, "Durch Schleifeninvarianten sind Schleifen im Debugger iterierbar.                  (3A)"),
                        new Choice(true, "Die negierte Abbruchbedingung ist Teil einer Schleifeninvariante.                  (3B)"),
                        new Choice(false, "Erfüllte Schleifeninvarianten garantieren Termination.                             (3C)"),
                        new Choice(false, "Schleifeninvarianten beschreiben, was Iterationen unverändert lassen.              (3D)"),
                        new Choice(true, "Schleifeninvarianten helfen dabei, Programme statisch zu verstehen.                (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?",

                        new Choice(false, "Alle Kommentare sind Zusicherungen entsprechend Design-by-Contract.                (4A)"),
                        new Choice(true, "Kommentare sollen aus Sicht der Anwendung geschrieben sein.                        (4B)"),
                        new Choice(true, "Die meisten Kommentare stehen an Schnittstellen (Methoden, Klassen).               (4C)"),
                        new Choice(true, "Nachbedingungen stehen hauptsächlich vor Methodenköpfen.                           (4D)"),
                        new Choice(false, "Invarianten stehen hauptsächlich bei Variablendeklarationen.                       (4E)")
                ),

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(true, "{w == -44} w += 1; {w == -43}                                                      (5A)"),
                        new Choice(true, "{true} w = 92; {w == 92}                                                           (5B)"),
                        new Choice(false, "{w == -43} w += 1; {w == -44}                                                      (5C)"),
                        new Choice(false, "{b <= 92} while (++w < -44) b--; {b < 92}                                          (5D)"),
                        new Choice(true, "{w > -43} if (w < -44) w--; {w > -43}                                              (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
            "    Java-Collections-Framework zu?\n" +
            "    \n" +
            "    XXXXXXXXX Aus einer Queue<E> kann man Elemente mittels poll und remove löschen.              (1A)\n" +
            "    XXXXXXXXX Collection<E> erlaubt mehrere gleiche Einträge.                                    (1B)\n" +
            "    XXXXXXXXX LinkedList<E> implementiert List<E>.                                               (1C)\n" +
            "    XXXXXXXXX TreeSet<E> ist Untertyp von SortedSet<E>.                                          (1D)\n" +
            "    XXXXXXXXX LinkedHashMap<K,V> ist eine lineare Liste, die Hashtabellen enthält.               (1E)\n" +
            "\n" +
            " 2. public int sumFrom1To(int x) { return (x * (x + 1)) / 2; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Vorbedingung: Gibt (x * (x + 1)) / 2 zurück.                                       (2A)\n" +
            "    XXXXXXXXX Nachbedingung: Halbiert (x * (x + 1)).                                             (2B)\n" +
            "    XXXXXXXXX Vorbedingung: Ergebnis hängt nur von x ab.                                         (2C)\n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis ist für x < 1 nicht die Zahlensumme.                       (2D)\n" +
            "    XXXXXXXXX Vorbedingung: x > 0.                                                               (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf Schleifen und Schleifeninvarianten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Durch Schleifeninvarianten sind Schleifen im Debugger iterierbar.                  (3A)\n" +
            "    XXXXXXXXX Die negierte Abbruchbedingung ist Teil einer Schleifeninvariante.                  (3B)\n" +
            "    XXXXXXXXX Erfüllte Schleifeninvarianten garantieren Termination.                             (3C)\n" +
            "    XXXXXXXXX Schleifeninvarianten beschreiben, was Iterationen unverändert lassen.              (3D)\n" +
            "    XXXXXXXXX Schleifeninvarianten helfen dabei, Programme statisch zu verstehen.                (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Alle Kommentare sind Zusicherungen entsprechend Design-by-Contract.                (4A)\n" +
            "    XXXXXXXXX Kommentare sollen aus Sicht der Anwendung geschrieben sein.                        (4B)\n" +
            "    XXXXXXXXX Die meisten Kommentare stehen an Schnittstellen (Methoden, Klassen).               (4C)\n" +
            "    XXXXXXXXX Nachbedingungen stehen hauptsächlich vor Methodenköpfen.                           (4D)\n" +
            "    XXXXXXXXX Invarianten stehen hauptsächlich bei Variablendeklarationen.                       (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {w == -44} w += 1; {w == -43}                                                      (5A)\n" +
            "    XXXXXXXXX {true} w = 92; {w == 92}                                                           (5B)\n" +
            "    XXXXXXXXX {w == -43} w += 1; {w == -44}                                                      (5C)\n" +
            "    XXXXXXXXX {b <= 92} while (++w < -44) b--; {b < 92}                                          (5D)\n" +
            "    XXXXXXXXX {w > -43} if (w < -44) w--; {w > -43}                                              (5E)\n" +
            "\n";

    public static final long UID = 247308593573824L;

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