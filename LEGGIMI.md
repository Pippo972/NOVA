# NOVA – Scanner smartphone (Android)

*Nuova Opportunità per Vecchi Apparecchi*

App per tablet Android 6.0 e successivi: logo → 2 pagine di presentazione → START →
scansione via cavo USB di uno smartphone → report PDF.

## Compilare con GitHub (consigliato: repository NUOVO e vuoto)
1. Crea un nuovo repository (es. "nova").
2. **Add file › Upload files**: trascina le cartelle `app` e `gradle` e i file
   `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, `gradlew`, `gradlew.bat`,
   `LEGGIMI.md`. Premi **Commit changes**.
3. **Add file › Create new file**: come nome scrivi `.github/workflows/build-apk.yml`
   e incolla il contenuto del file `build-apk.yml` che trovi nella cartella `.github/workflows`
   di questo progetto. Premi **Commit changes**.
4. Scheda **Actions** › "Compila APK" › a fine compilazione (✓ verde) scarica **NOVA-APK**
   dalla sezione Artifacts ed estrai `NOVA.apk`.

## Compilare con Android Studio
Android Studio Koala (2024.1) o più recente: **File › Open** › cartella `NOVA` ›
**Build › Build App Bundle(s) / APK(s) › Build APK(s)**.
L'APK è in `app/build/outputs/apk/debug/app-debug.apk`.

## Installazione sul tablet (Android 6)
Attiva **Impostazioni › Sicurezza › Origini sconosciute**, copia `NOVA.apk` sul tablet e aprilo.

## Uso
1. Smartphone da analizzare: Impostazioni › Info telefono › tocca 7 volte "Numero build",
   poi Impostazioni › Opzioni sviluppatore › attiva "Debug USB".
2. Collega lo smartphone al tablet: l'adattatore/cavo OTG va dal lato del TABLET.
3. Nell'app premi START, poi "AVVIA SCANSIONE".
4. Sul tablet conferma l'accesso USB; sullo smartphone conferma "Consenti debug USB"
   (spunta "Consenti sempre" per non doverlo rifare).
5. Il report PDF viene salvato in `Android/data/it.nova.scanner/files/Documents/`
   e si può aprire o condividere.

## Dati rilevati
Produttore, modello, numero di serie, versione Android e patch di sicurezza, stato bootloader,
batteria (livello, stato, salute, tensione, temperatura, tecnologia), RAM, memoria interna
(totale/usata/libera), risoluzione schermo, stato SIM e operatore.
Tutto in sola lettura: nessun dato personale viene letto o modificato.

## Struttura
- `app/src/main/java/it/nova/scanner/` – schermate, analisi dati, report PDF
- `app/src/main/java/it/nova/scanner/adb/` – comunicazione ADB via USB
- `app/src/main/res/` – logo, icone, font Outfit, layout
