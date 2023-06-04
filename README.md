## Projekta apraksts

### Pārskats

Šis projekts satur testus BTA Ceļojuma apdrošināšanas tīmekļa lapai. Šie testi ir izstrādāti, izmantojot TestNG un Selenide.
### Nepieciešamības

Lai palaistu testus, ir nepieciešams uzstādīt sekojošo programmatūru:

- Git 2.35.3 vai jaunāks: lai klonētu repozitoriju
- Java Development Kit (JDK) 1.8: lai kompilētu un palaistu testus
- Maven 3.8.0 vai jaunāks: lai pārvaldītu projekta būvi

### Repo klonēšana

Vispirms ir nepieciešams noklonēt repo uz lokālā datora. Atveriet termināli un navigējiet uz direktoriju, kurā vēlaties noklonēt repo, tad izpildiet:

```git clone https://github.com/eduardblumental/bta-celojumu-polises-tests.git```

Kad repo ir noklonēta, navigējiet uz projekta mapi:

```cd bta-celojumu-polises-tests```

### Testu kompilēšana un palaišana

Kompilējiet un palaidiet testus, izpildot šādu komandu:

```mvn clean -fae test```

Šī komanda vispirms notīrīs jebkuras iepriekšējas būves, tad tā kompilēs avota kodu un beigās palaidīs testus.

Testa palaišanas rezultāti tiks izdrukāti terminālī. Detalizētus testa pārskatus var atrast direktorijā `target/surefire-reports`.
