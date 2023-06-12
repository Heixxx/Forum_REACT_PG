package controllers;

import common.TPerson;
import controllers.models.Authority;
import controllers.models.Category;
import controllers.models.Comment;
import controllers.models.Person;
import controllers.models.Post;
import controllers.models.User;
import controllers.models.Uzytkownik;
import controllers.repositories.AuthorityRepository;
import controllers.repositories.CategoryRepository;
import controllers.repositories.CommentRepository;
import controllers.repositories.PersonRepository;
import controllers.repositories.PostRepository;
import controllers.repositories.UserRepository;
import controllers.repositories.UzytkownikRepository;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class MyDataBase {

        @Autowired
        PersonRepository personRepository;

        @Autowired
        CategoryRepository categoryRepository;

        @Autowired
        PostRepository postRepository;

        @Autowired
        CommentRepository commentRepository;

        @Autowired
        UzytkownikRepository uzytkownikRepository;

        @Autowired
        UserRepository userRepository;

        @Autowired
        AuthorityRepository authorityRepository;

        public MyDataBase() {
        }

        public void addPerson(String email, String firstName, String lastName, int age) {

                Person locPerson = personRepository.findByEmail(email);

                if (locPerson != null) {
                        throw new IllegalArgumentException("Użytkownik " + email + " już istnieje w bazie");
                }

                Person person = new Person(email, firstName, lastName, age);
                personRepository.save(person);
        }

        // public ArrayList<TPerson> getPersonList() {

        // List<Person> personList = personRepository.findAll();

        // if (personList == null) {
        // throw new IllegalArgumentException("Nie ma danych");
        // }

        // ArrayList<TPerson> locPersonList = new ArrayList<>();

        // for (int i = 0; i < personList.size(); i++) {
        // Person person = personList.get(i);
        // TPerson locUser = new TPerson(person);
        // locPersonList.add(locUser);
        // }

        // return locPersonList;
        // }

        // public void deletePerson(String emailToRemove) {

        // Person locPerson = personRepository.findByEmail(emailToRemove);

        // if (locPerson == null) {
        // throw new IllegalArgumentException("Użytkownik " + emailToRemove + " nie
        // istnieje w bazie");
        // }

        // personRepository.delete(locPerson);
        // }

        // FUNCKJA DO TESTOWANIA INSERTÓW I POPRAWNOŚCI DANYCH W ZWIĄZKU Z KLUCZAMI I
        // RELACJAMI

        // testowe dodawanie kategorii w celu sprawdzenia poprawnosci
        public void addCategory() {
                // sekcja testowania wstawiania kategorii
                Category newCategory = new Category("Informatyka");
                Category newCategory1 = new Category("Wędkarstwo");
                Category newCategory2 = new Category("Elektronika");
                Category newCategory3 = new Category("Budownictwo");
                Category newCategory4 = new Category("Mechanika");
                Category newCategory5 = new Category("Inne");

                categoryRepository.save(newCategory);
                categoryRepository.save(newCategory1);
                categoryRepository.save(newCategory2);
                categoryRepository.save(newCategory3);
                categoryRepository.save(newCategory4);
                categoryRepository.save(newCategory5);

                // czas
                Date javaDate = new Date();
                long javaTime = javaDate.getTime();
                Timestamp sqlTimestamp = new Timestamp(javaTime);

                // sekcja testowa postów

                        //Informatyka 
                Post testPost = new Post(newCategory, sqlTimestamp, "Dlaczego PANS jest najlepszą uczelnią w kraju a może nawet na podkarpaciu ;)", "O wyższości PANS nad innymi uczelniami");
                Post testPost1 = new Post(newCategory, sqlTimestamp,
                                "Dlaczego informatycy tyle zarabiają a osoby na budowie zarabiają mniej :(((", "Jak zarobić i sie nie narobić - życie informatyka");
                Post testPost2 = new Post(newCategory, sqlTimestamp, "Czemu na informatyce trzeba coś robi, jest to niedopuszczalne", "Informatyka to ciężki kawałek chleba");
                Post testPost3 = new Post(newCategory, sqlTimestamp, "Lubie grać w gry - głównie minecraft i fortnite - czy warto w takim przypadku studiować informatyke?", "Gram w gry, czy warto studiować informatyka");
                Post testPost4 = new Post(newCategory, sqlTimestamp, "Proszę o podanie argumentów do twierdzenia postawionego w pytaniu :) ", "Dlaczego JAVA to najlepszy język programowania");
                Post testPost5 = new Post(newCategory, sqlTimestamp, "Zapraszamy wszystkich zainteresowanych do zespołu 9bits - praca w super zespole i OWOCOWE WTORKI", "Praca w 9bits - najlepszy wybór dla studenta PANS");


                postRepository.save(testPost);
                postRepository.save(testPost1);
                postRepository.save(testPost2);
                postRepository.save(testPost3);
                postRepository.save(testPost4);
                postRepository.save(testPost5);

                

                // sekcja testowa komentarzy

                Comment newComment = new Comment(testPost, sqlTimestamp, "PANS GUROM!!!!!!!111!1", null,
                                "TRYBEK");
                Comment newComment1 = new Comment(testPost, sqlTimestamp, "+1 byczqu", null,
                                "nieTrybek");
                Comment newComment2 = new Comment(testPost, sqlTimestamp, "KPU było lepszą nazwą :/", null,
                                "ania96");
                Comment newComment3 = new Comment(testPost, sqlTimestamp, "PWSZ to dopiero była nazwa", null,
                                "janusz95");
                Comment newComment4 = new Comment(testPost, sqlTimestamp, "Polecam tą uczelnie, fajnie się tam bawiłem", null,
                                "NorbertG");
                
                

                commentRepository.save(newComment);
                commentRepository.save(newComment1);
                commentRepository.save(newComment2);
                commentRepository.save(newComment3);
                commentRepository.save(newComment4);

                Comment newComment11 = new Comment(testPost1, sqlTimestamp, "Automatyzacja to klucz. Skryptuj swoje zadania, aby oszczędzać czas i energia nie musząc ciągle powtarzać tych samych czynności.", null, "KodowanieZwyciestwo");

                Comment newComment21 = new Comment(testPost1, sqlTimestamp, "Rozważ przeniesienie części swojej pracy na chmurę. Może to przynieść wiele korzyści, w tym redukcję kosztów oraz zwiększenie efektywności.", null, "ChmuraFan");

                Comment newComment31 = new Comment(testPost1, sqlTimestamp, "Nigdy nie przestawaj się uczyć. Technologie IT rozwijają się bardzo szybko, a to co było aktualne kilka lat temu, teraz może być już przestarzałe.", null, "NaukaToPodstawa");

                Comment newComment41 = new Comment(testPost1, sqlTimestamp, "Spróbuj zastosować metodykę Agile w swojej pracy. Pozwala ona na lepszą organizację zadań i ciągłą adaptację do zmieniających się okoliczności.", null, "AgileMaster");

                Comment newComment51 = new Comment(testPost1, sqlTimestamp, "Pamiętaj o balansie między życiem prywatnym a pracą. Odpoczynek jest niezwykle ważny, aby utrzymać wysoką produktywność i nie wypalić się.", null, "ZdrowyInformatyk");

                commentRepository.save(newComment11);
                commentRepository.save(newComment21);
                commentRepository.save(newComment31);
                commentRepository.save(newComment41);
                commentRepository.save(newComment51);

                Comment newComment12 = new Comment(testPost2, sqlTimestamp, "Informatyka to faktycznie wymagający obszar, ale pamiętaj, że kluczem jest ciągłe uczestnictwo w procesie nauki.", null, "UczonyNerd");

                Comment newComment22 = new Comment(testPost2, sqlTimestamp, "Zgadza się, informatyka może być trudna, ale satysfakcja z rozwiązania trudnego problemu lub zobaczenia działającego kodu jest nieoceniona.", null, "CodeLover");

                Comment newComment32 = new Comment(testPost2, sqlTimestamp, "Trudności w informatyce często wynikają z szybko zmieniającej się technologii. Ważne jest, aby wybrać jedną dziedzinę i skupić się na niej.", null, "SpecialistAdvice");

                Comment newComment42 = new Comment(testPost2, sqlTimestamp, "Informatyka może być trudna, ale pamiętaj, że każdy z nas zaczynał od zera. Nie bój się pytać o pomoc i korzystać z dostępnych zasobów.", null, "NewbieGuide");

                Comment newComment52 = new Comment(testPost2, sqlTimestamp, "To prawda, że informatyka to ciężki kawałek chleba, ale pamiętaj, że są społeczności, które mogą pomóc Ci przetrwać trudne chwile. Nie jesteś w tym sam!", null, "SupportiveTechie");

                commentRepository.save(newComment12);
                commentRepository.save(newComment22);
                commentRepository.save(newComment32);
                commentRepository.save(newComment42);
                commentRepository.save(newComment52);

                Comment newComment13 = new Comment(testPost4, sqlTimestamp, "JAVA to język o dużej społeczności, co znaczy, że zawsze można znaleźć pomoc i wiele zasobów do nauki.", null, "JavaCommunityLover");

                Comment newComment23 = new Comment(testPost4, sqlTimestamp, "JAVA jest platformą niezależną - 'Napisz raz, uruchom wszędzie'. To sprawia, że jest to język niezwykle uniwersalny.", null, "UniversalJavaFan");

                Comment newComment33 = new Comment(testPost4, sqlTimestamp, "JAVA oferuje mocne wsparcie dla obiektowości, co czyni go świetnym wyborem do tworzenia skomplikowanych, wieloskładnikowych systemów.", null, "OOPChampion");

                Comment newComment43 = new Comment(testPost4, sqlTimestamp, "Dzięki dobrej obsłudze wielowątkowości, JAVA jest idealna do tworzenia aplikacji wymagających wysokiej wydajności.", null, "HighPerformanceJava");

                Comment newComment53 = new Comment(testPost4, sqlTimestamp, "JAVA jest używana w wielu dużych korporacjach i na wielu rożnych platformach, co oznacza, że umiejętność programowania w tym języku jest bardzo ceniona na rynku pracy.", null, "JobMarketObserver");

                commentRepository.save(newComment13);
                commentRepository.save(newComment23);
                commentRepository.save(newComment33);
                commentRepository.save(newComment43);
                commentRepository.save(newComment53);

                Comment newComment14 = new Comment(testPost3, sqlTimestamp, "Studia informatyczne mogą pomóc Ci zrozumieć, jak działają gry, które lubisz. Możesz nawet skończyć tworząc swoją własną grę!", null, "GameDevDreamer");

                Comment newComment24 = new Comment(testPost3, sqlTimestamp, "Pasja do gier to świetny punkt wyjścia, ale pamiętaj, że informatyka to dużo więcej niż tylko gry. Jest to bardzo szeroki obszar, który oferuje wiele możliwości.", null, "BeyondGaming");

                Comment newComment34 = new Comment(testPost3, sqlTimestamp, "Informatyka jest jednym z najszybciej rozwijających się obszarów. Jeśli lubisz gry i technologię, warto rozważyć tę ścieżkę kariery.", null, "TechCareerAdvocate");

                Comment newComment44 = new Comment(testPost3, sqlTimestamp, "Jeśli zastanawiasz się nad studiami informatycznymi, zawsze możesz spróbować nauki programowania na własną rękę. Może to pomóc Ci zdecydować, czy to jest coś, co naprawdę Cię interesuje.", null, "DIYCoder");

                Comment newComment54 = new Comment(testPost3, sqlTimestamp, "To, czy warto studiować informatykę, zależy od Twoich osobistych zainteresowań i celów kariery. Jeśli jesteś zainteresowany technologią i chcesz pracować w tej branży, to może być dla Ciebie dobra opcja.", null, "CareerAdvisor");


                commentRepository.save(newComment14);
                commentRepository.save(newComment24);
                commentRepository.save(newComment34);
                commentRepository.save(newComment44);
                commentRepository.save(newComment54);

                Comment newComment15 = new Comment(testPost5, sqlTimestamp, "9bits oferuje wiele możliwości dla studentów. Szczególnie cenię ich programy praktyk i staży.", null, "9bitsIntern");

                Comment newComment25 = new Comment(testPost5, sqlTimestamp, "Pracowałem w 9bits podczas studiów na PANS i muszę przyznać, że zdobyłem tam bezcenne doświadczenie.", null, "Ex9bits");

                Comment newComment35 = new Comment(testPost5, sqlTimestamp, "9bits to świetne miejsce do nauki. Wspierają ciągły rozwój, co jest kluczowe dla studenta.", null, "ProLearning");

                Comment newComment45 = new Comment(testPost5, sqlTimestamp, "Praca w 9bits dała mi realne doświadczenie w branży IT, czego nie zawsze dostajesz na studiach. Polecam.", null, "RealWorldCoder");

                Comment newComment55 = new Comment(testPost5, sqlTimestamp, "9bits jest znane z elastycznego podejścia do godzin pracy, co jest niewątpliwie plusem dla studenta próbującego pogodzić naukę z pracą.", null, "FlexTimeFan");

                commentRepository.save(newComment15);
                commentRepository.save(newComment25);
                commentRepository.save(newComment35);
                commentRepository.save(newComment45);
                commentRepository.save(newComment55);


                //Wędkarstwo

                Post fishingPost = new Post(newCategory1, sqlTimestamp, "Dlaczego rzeka San to najlepsze miejsce do łowienia troci?", "Sekret rzeki San");
                Post fishingPost1 = new Post(newCategory1, sqlTimestamp, "Czy warto zainwestować w drogie sprzęty wędkarskie czy lepsze jest 'łowienie na żywca'?", "Sprzęt vs natura");
                Post fishingPost2 = new Post(newCategory1, sqlTimestamp, "Czy zimowe wędkowanie jest naprawdę takie dobre jak mówią?", "Zimowe wyzwania wędkarza");
                Post fishingPost3 = new Post(newCategory1, sqlTimestamp, "Uwielbiam spędzać czas na łodzi wędkując. Czy warto więc iść na kurs sternika?", "Łódź, wędkowanie i sternik");
                Post fishingPost4 = new Post(newCategory1, sqlTimestamp, "Proszę o podanie argumentów do twierdzenia postawionego w pytaniu :) ", "Dlaczego spławik to najlepszy przyjaciel wędkarza?");
                Post fishingPost5 = new Post(newCategory1, sqlTimestamp, "Zapraszamy wszystkich pasjonatów wędkarstwa do naszego klubu 'Złoty Karp' - miła atmosfera i wspólne wyjazdy gwarantowane!", "Dołącz do 'Złotego Karpa'!");

                postRepository.save(fishingPost);
                postRepository.save(fishingPost1);
                postRepository.save(fishingPost2);
                postRepository.save(fishingPost3);
                postRepository.save(fishingPost4);
                postRepository.save(fishingPost5);

                // sekcja testowa komentarzy

                Comment fishingComment = new Comment(fishingPost, sqlTimestamp, "San to absolutna perełka! Łowię tam od lat i zawsze wracam zadowolony.", null, "RybakSan");
                Comment fishingComment1 = new Comment(fishingPost, sqlTimestamp, "San ma niesamowitą populację troci. Plus piękne otoczenie!", null, "TroutLover");
                Comment fishingComment2 = new Comment(fishingPost, sqlTimestamp, "Właśnie wróciłem z San, złowiłem trocię 70 cm!", null, "LuckyFisher");
                Comment fishingComment3 = new Comment(fishingPost, sqlTimestamp, "Zdecydowanie polecam San. Dobre miejsce dla zarówno początkujących jak i doświadczonych wędkarzy.", null, "FishingGuide");
                Comment fishingComment4 = new Comment(fishingPost, sqlTimestamp, "Nigdy nie byłem na San, ale po przeczytaniu waszych komentarzy, muszę tam pojechać!", null, "Newbie");

                commentRepository.save(fishingComment);
                commentRepository.save(fishingComment1);
                commentRepository.save(fishingComment2);
                commentRepository.save(fishingComment3);
                commentRepository.save(fishingComment4);

                Comment newFishingComment = new Comment(fishingPost, sqlTimestamp, "SAN RULEZZZ!!!!!!!111!1", null,
                            "RybakZSanu");
            Comment newFishingComment1 = new Comment(fishingPost, sqlTimestamp, "+1 zgadzam się", null,
                            "PstragMaster");
            Comment newFishingComment2 = new Comment(fishingPost, sqlTimestamp, "Wisła była lepszą rzeką :/", null,
                            "WislokFan");
            Comment newFishingComment3 = new Comment(fishingPost, sqlTimestamp, "Odra to dopiero była rzeka", null,
                            "OdraOldFisher");
            Comment newFishingComment4 = new Comment(fishingPost, sqlTimestamp, "Polecam tą rzekę, fajnie się tam łowiło", null,
                            "SpinningStar");

            commentRepository.save(newFishingComment);
            commentRepository.save(newFishingComment1);
            commentRepository.save(newFishingComment2);
            commentRepository.save(newFishingComment3);
            commentRepository.save(newFishingComment4);

            Comment newFishingComment11 = new Comment(fishingPost1, sqlTimestamp, "Tajemnicą jest odpowiednie przynęty. Zmieniaj swoje przynęty, a ryby będą biegać do Ciebie!", null, "BaitMaster");
            Comment newFishingComment12 = new Comment(fishingPost1, sqlTimestamp, "Cierpliwość to klucz do sukcesu w wędkarstwie!", null, "FishWhisperer");
            Comment newFishingComment13 = new Comment(fishingPost1, sqlTimestamp, "Wędkarstwo to więcej niż łowienie. To kontakt z naturą i relaks. Może to właśnie Cię boli?", null, "NatureLover");
            commentRepository.save(newFishingComment11);
            commentRepository.save(newFishingComment12);
            commentRepository.save(newFishingComment13);

            Comment newFishingComment21 = new Comment(fishingPost2, sqlTimestamp, "Bo to nie jest dla wszystkich. Ale dla tych, którzy to rozumieją, to nie ma nic lepszego!", null, "PassionateFisher");
            Comment newFishingComment22 = new Comment(fishingPost2, sqlTimestamp, "Powinieneś spróbować spinningu. To bardziej dynamiczne.", null, "SpinningGuru");
            
            commentRepository.save(newFishingComment21);
            commentRepository.save(newFishingComment22);

            Comment newFishingComment31 = new Comment(fishingPost3, sqlTimestamp, "Zdecydowanie tak! Wędkarstwo daje Ci możliwość obserwacji przyrody z bliska i w ciszy.", null, "BirdAndFishWatcher");
            Comment newFishingComment32 = new Comment(fishingPost3, sqlTimestamp, "Pamiętaj, że wędkarstwo to również odpowiedzialność. Musisz szanować ryby i środowisko, w którym łowisz.", null, "GreenFisher");

            commentRepository.save(newFishingComment31);
            commentRepository.save(newFishingComment32);

            Comment newFishingComment41 = new Comment(fishingPost4, sqlTimestamp, "Spinning to szybkość, precyzja i moc. Dla mnie to najlepsza technika łowienia.", null, "SpinKing");
            Comment newFishingComment42 = new Comment(fishingPost4, sqlTimestamp, "Dla mnie flyfishing jest lepszy. Ale to kwestia gustu.", null, "FlyFishingAddict");

            commentRepository.save(newFishingComment41);
            commentRepository.save(newFishingComment42);

            Comment newFishingComment51 = new Comment(fishingPost5, sqlTimestamp, "Super klub! Członek od 2 lat i nie zamieniłbym na inny.", null, "KarpieKolejFan");
            Comment newFishingComment52 = new Comment(fishingPost5, sqlTimestamp, "Czy przyjmują nowych członków? Chciałbym dołączyć.", null, "FishingNovice");

            commentRepository.save(newFishingComment51);
            commentRepository.save(newFishingComment52);


                Post electronicsPost = new Post(newCategory2, sqlTimestamp, "Czy warto zainwestować w najnowszy model iPhone'a?", "Porównanie iPhone'a z innymi smartfonami na rynku");
                Post electronicsPost1 = new Post(newCategory2, sqlTimestamp, "Jakie są najlepsze laptopy dla graczy?", "Recenzja laptopów gamingowych");
                Post electronicsPost2 = new Post(newCategory2, sqlTimestamp, "Czy konsola do gier to dobry pomysł dla dziecka?", "Zalety i wady konsol do gier dla dzieci");
                Post electronicsPost3 = new Post(newCategory2, sqlTimestamp, "Jaki jest dobry starter kit dla początkującego entuzjasty Raspberry Pi?", "Początki z Raspberry Pi");
                Post electronicsPost4 = new Post(newCategory2, sqlTimestamp, "Jak wybrać najlepszy telewizor do domowego kina?", "Przewodnik po telewizorach do domowego kina");

                postRepository.save(electronicsPost);
                postRepository.save(electronicsPost1);
                postRepository.save(electronicsPost2);
                postRepository.save(electronicsPost3);
                postRepository.save(electronicsPost4);

                Comment newCommentelectronic = new Comment(electronicsPost, sqlTimestamp, "Zdecydowanie warto! Nowy iPhone ma świetne funkcje!", null, "TechGuru");
                Comment newCommentelectronic1 = new Comment(electronicsPost, sqlTimestamp, "Osobiście wolę Androida", null, "AndroidFan");
                Comment newCommentelectronic2 = new Comment(electronicsPost1, sqlTimestamp, "Polecam laptop Alienware, sam go używam i jestem zadowolony", null, "GameLover");
                Comment newCommentelectronic3 = new Comment(electronicsPost2, sqlTimestamp, "Moim zdaniem lepsze są edukacyjne gry na komputerze", null, "ConcernedParent");
                Comment newCommentelectronic4 = new Comment(electronicsPost3, sqlTimestamp, "Canakit Raspberry Pi 4 jest świetnym starter kit", null, "PiDev");

                commentRepository.save(newCommentelectronic);
                commentRepository.save(newCommentelectronic1);
                commentRepository.save(newCommentelectronic2);
                commentRepository.save(newCommentelectronic3);
                commentRepository.save(newCommentelectronic4);

                Comment newCommentelectronic5 = new Comment(electronicsPost1, sqlTimestamp, "Asus ROG to dobry wybór dla gracza!", null, "PcMasterRace");
                Comment newCommentelectronic6 = new Comment(electronicsPost1, sqlTimestamp, "Nie zapominajmy o dobrym chłodzeniu w laptopach do gier", null, "HeatKiller");
                Comment newCommentelectronic7 = new Comment(electronicsPost1, sqlTimestamp, "Sprawdź MSI, mają dobre modele dla graczy", null, "GamerExpert");
                Comment newCommentelectronic8 = new Comment(electronicsPost1, sqlTimestamp, "Ja osobiście wolę gry na konsoli", null, "ConsoleGamer");

                Comment newCommentelectronic9 = new Comment(electronicsPost2, sqlTimestamp, "Ważne, aby ograniczyć czas spędzany przez dzieci przed ekranem", null, "MindfulMom");
                Comment newCommentelectronic10 = new Comment(electronicsPost2, sqlTimestamp, "Moje dzieci uwielbiają Nintendo Switch!", null, "DadOfTwo");
                Comment newCommentelectronic11 = new Comment(electronicsPost2, sqlTimestamp, "Pamiętaj, aby sprawdzić rodzicielskie ustawienia kontroli na konsoli", null, "SafetyFirst");
                Comment newCommentelectronic12 = new Comment(electronicsPost2, sqlTimestamp, "Edukacyjne gry na konsolach mogą być bardzo pomocne w nauce", null, "TeacherPerspective");

                Comment newCommentelectronic13 = new Comment(electronicsPost3, sqlTimestamp, "Zestaw startowy ELEGOO jest też dobrym wyborem", null, "IoTGeek");
                Comment newCommentelectronic14 = new Comment(electronicsPost3, sqlTimestamp, "Pamiętaj, aby kupić odpowiedni zasilacz dla Raspberry Pi", null, "PiPro");
                Comment newCommentelectronic15 = new Comment(electronicsPost3, sqlTimestamp, "Raspberry Pi to świetna zabawa, ale wymaga pewnego poziomu wiedzy technicznej", null, "TechSavvy");
                Comment newCommentelectronic16 = new Comment(electronicsPost3, sqlTimestamp, "Zawsze można zacząć od prostszych projektów, są dostępne różne poradniki online", null, "BeginnerFriendly");

                Comment newCommentelectronic17 = new Comment(electronicsPost4, sqlTimestamp, "OLED LG to obecnie najwyższa półka", null, "TvLover");
                Comment newCommentelectronic18 = new Comment(electronicsPost4, sqlTimestamp, "Rozważ zakup telewizora 4K dla najlepszego doświadczenia z domowym kinem", null, "MovieBuff");
                Comment newCommentelectronic19 = new Comment(electronicsPost4, sqlTimestamp, "Samsung robi dobre telewizory, ale cena może być wysoka", null, "BudgetWatcher");
                Comment newCommentelectronic20 = new Comment(electronicsPost4, sqlTimestamp, "Jeszcze ważniejszy od telewizora jest dobry system dźwięku!", null, "SoundExpert");

                commentRepository.save(newCommentelectronic5);
                commentRepository.save(newCommentelectronic6);
                commentRepository.save(newCommentelectronic7);
                commentRepository.save(newCommentelectronic8);
                commentRepository.save(newCommentelectronic9);
                commentRepository.save(newCommentelectronic10);
                commentRepository.save(newCommentelectronic11);
                commentRepository.save(newCommentelectronic12);
                commentRepository.save(newCommentelectronic13);
                commentRepository.save(newCommentelectronic14);
                commentRepository.save(newCommentelectronic15);
                commentRepository.save(newCommentelectronic16);
                commentRepository.save(newCommentelectronic17);
                commentRepository.save(newCommentelectronic18);
                commentRepository.save(newCommentelectronic19);
                commentRepository.save(newCommentelectronic20);


                Post constructionPost = new Post(newCategory3, sqlTimestamp, "Jakie są najlepsze techniki budowy domów energooszczędnych?", "Poradnik po technologiach budowy domów energooszczędnych");
                Post constructionPost1 = new Post(newCategory3, sqlTimestamp, "Jaki jest najlepszy materiał do izolacji domu?", "Porównanie materiałów izolacyjnych");
                Post constructionPost2 = new Post(newCategory3, sqlTimestamp, "Czy warto inwestować w domy modułowe?", "Zalety i wady domów modułowych");
                Post constructionPost3 = new Post(newCategory3, sqlTimestamp, "Jak wybrać najlepszą firmę remontową?", "Poradnik wyboru firmy remontowej");
                Post constructionPost4 = new Post(newCategory3, sqlTimestamp, "Jak zaplanować optymalny układ pokoju?", "Poradnik do planowania układu pokoju");

                postRepository.save(constructionPost);
                postRepository.save(constructionPost1);
                postRepository.save(constructionPost2);
                postRepository.save(constructionPost3);
                postRepository.save(constructionPost4);

                Comment newCommentconstruction = new Comment(constructionPost, sqlTimestamp, "Bardzo polecam technikę pasywną. Koszty inwestycji zwracają się po kilku latach.", null, "EcoBuilder");
                Comment newCommentconstruction1 = new Comment(constructionPost, sqlTimestamp, "Należy pamiętać, że każdy projekt domu jest inny i wymaga indywidualnego podejścia.", null, "ArchitectMaster");
                Comment newCommentconstruction2 = new Comment(constructionPost1, sqlTimestamp, "Osobiście polecam wełnę mineralną. Świetnie izoluje.", null, "IsolationExpert");
                Comment newCommentconstruction3 = new Comment(constructionPost2, sqlTimestamp, "Domy modułowe to przyszłość! Szybko się je stawia i są bardzo funkcjonalne.", null, "ModularHomesFan");
                Comment newCommentconstruction4 = new Comment(constructionPost3, sqlTimestamp, "Pamiętajcie, że tanie nie zawsze oznacza dobre. Lepiej zapłacić więcej, ale mieć gwarancję jakości.", null, "RenovationGuru");

                commentRepository.save(newCommentconstruction);
                commentRepository.save(newCommentconstruction1);
                commentRepository.save(newCommentconstruction2);
                commentRepository.save(newCommentconstruction3);
                commentRepository.save(newCommentconstruction4);

                Comment newCommentconstruction5 = new Comment(constructionPost1, sqlTimestamp, "Uważam, że pianka poliuretanowa jest lepsza.", null, "GreenBuilder");
                Comment newCommentconstruction6 = new Comment(constructionPost1, sqlTimestamp, "Ja stosuję styropian, jest tani i efektywny.", null, "BudgetConstructor");
                Comment newCommentconstruction7 = new Comment(constructionPost2, sqlTimestamp, "Należy wziąć pod uwagę lokalne przepisy budowlane.", null, "LegalAdvisor");
                Comment newCommentconstruction8 = new Comment(constructionPost3, sqlTimestamp, "Zawsze sprawdź referencje firmy remontowej!", null, "CarefulCustomer");
                Comment newCommentconstruction9 = new Comment(constructionPost4, sqlTimestamp, "Pamiętaj o odpowiednim oświetleniu podczas planowania układu.", null, "LightingDesigner");

                commentRepository.save(newCommentconstruction5);
                commentRepository.save(newCommentconstruction6);
                commentRepository.save(newCommentconstruction7);
                commentRepository.save(newCommentconstruction8);
                commentRepository.save(newCommentconstruction9);

                Comment newCommentconstruction10 = new Comment(constructionPost3, sqlTimestamp, "Ustal wszystko na piśmie, aby uniknąć późniejszych nieporozumień.", null, "SmartClient");
                Comment newCommentconstruction11 = new Comment(constructionPost4, sqlTimestamp, "Bardzo ważne jest, aby pokój był funkcjonalny.", null, "InteriorDesigner");
                Comment newCommentconstruction12 = new Comment(constructionPost4, sqlTimestamp, "Przy planowaniu układu pokoju warto wziąć pod uwagę kierunki świata.", null, "FengShuiExpert");

                commentRepository.save(newCommentconstruction10);
                commentRepository.save(newCommentconstruction11);
                commentRepository.save(newCommentconstruction12);


                Comment newCommentconstruction13 = new Comment(constructionPost, sqlTimestamp, "Ciepłochronne betony to także dobra opcja dla domów energooszczędnych.", null, "ConcretePro");
                Comment newCommentconstruction14 = new Comment(constructionPost1, sqlTimestamp, "Nie zapominajmy o ekologicznych opcjach izolacji, takich jak celuloza.", null, "EcoFriendly");
                Comment newCommentconstruction15 = new Comment(constructionPost2, sqlTimestamp, "Przy domach modułowych warto też zwrócić uwagę na kwestie transportu.", null, "TransportIssues");
                Comment newCommentconstruction16 = new Comment(constructionPost3, sqlTimestamp, "Podpisz umowę tylko po przeczytaniu jej całej zawartości!", null, "ReadTheFinePrint");
                Comment newCommentconstruction17 = new Comment(constructionPost4, sqlTimestamp, "Zawsze konsultuj układ pokoju z profesjonalnym projektantem wnętrz.", null, "DesignExpert");

                Comment newCommentconstruction18 = new Comment(constructionPost, sqlTimestamp, "Domy z bali drewnianych także są energooszczędne i mają swój unikalny urok.", null, "WoodLover");
                Comment newCommentconstruction19 = new Comment(constructionPost1, sqlTimestamp, "Czasami warto połączyć kilka różnych materiałów izolacyjnych dla najlepszego efektu.", null, "IsolationCombo");
                Comment newCommentconstruction20 = new Comment(constructionPost2, sqlTimestamp, "Domy modułowe nie zawsze muszą wyglądać nowocześnie, można je dostosować do różnych stylów.", null, "StyleMatters");
                Comment newCommentconstruction21 = new Comment(constructionPost3, sqlTimestamp, "Upewnij się, że firma remontowa ma ubezpieczenie na wypadek ewentualnych szkód.", null, "InsuranceCheck");
                Comment newCommentconstruction22 = new Comment(constructionPost4, sqlTimestamp, "Pamiętaj, że każda zmiana układu pokoju może wymagać aktualizacji instalacji elektrycznej.", null, "ElectricitySafety");

                commentRepository.save(newCommentconstruction13);
                commentRepository.save(newCommentconstruction14);
                commentRepository.save(newCommentconstruction15);
                commentRepository.save(newCommentconstruction16);
                commentRepository.save(newCommentconstruction17);
                commentRepository.save(newCommentconstruction18);
                commentRepository.save(newCommentconstruction19);
                commentRepository.save(newCommentconstruction20);
                commentRepository.save(newCommentconstruction21);
                commentRepository.save(newCommentconstruction22);

                Post otherPost = new Post(newCategory5, sqlTimestamp, "Jakie są najlepsze książki do czytania?", "Poradnik dla miłośników literatury");
                Post otherPost1 = new Post(newCategory5, sqlTimestamp, "Jaka jest najzdrowsza dieta?", "Porównanie diet zdrowotnych");
                Post otherPost2 = new Post(newCategory5, sqlTimestamp, "Jak skutecznie nauczyć się nowego języka?", "Poradnik do nauki języków");
                Post otherPost3 = new Post(newCategory5, sqlTimestamp, "Jakie są najlepsze metody na relaks?", "Sposoby na odstresowanie");
                Post otherPost4 = new Post(newCategory5, sqlTimestamp, "Czy warto zainwestować w kryptowaluty?", "Poradnik inwestowania w kryptowaluty");

                postRepository.save(otherPost);
                postRepository.save(otherPost1);
                postRepository.save(otherPost2);
                postRepository.save(otherPost3);
                postRepository.save(otherPost4);
                
                Comment newCommentother = new Comment(otherPost, sqlTimestamp, "Zależy od Twojego gustu. Ja osobiście lubię fantasy i polecam 'Wiedźmina'.", null, "Bookworm");
                Comment newCommentother1 = new Comment(otherPost1, sqlTimestamp, "Dieta powinna być dostosowana do indywidualnych potrzeb. Polecam konsultację z dietetykiem.", null, "HealthyLiving");
                Comment newCommentother2 = new Comment(otherPost2, sqlTimestamp, "Duolingo to fajna aplikacja do nauki języków.", null, "LanguageLover");
                Comment newCommentother3 = new Comment(otherPost3, sqlTimestamp, "Medytacja pomaga mi się zrelaksować. Polecam spróbować.", null, "ZenMaster");
                Comment newCommentother4 = new Comment(otherPost4, sqlTimestamp, "Inwestowanie w kryptowaluty to duża szansa, ale także ryzyko. Radzę zasięgnąć porady eksperta.", null, "CryptoGuru");

                commentRepository.save(newCommentother);
                commentRepository.save(newCommentother1);
                commentRepository.save(newCommentother2);
                commentRepository.save(newCommentother3);
                commentRepository.save(newCommentother4);

                Comment newCommentother5 = new Comment(otherPost, sqlTimestamp, "Nie mogę się oderwać od thrillerów psychologicznych. Polecam 'Dziewczynę z pociągu'.", null, "ThrillerFan");
                Comment newCommentother6 = new Comment(otherPost1, sqlTimestamp, "Dieta śródziemnomorska jest uważana za jedną z najzdrowszych.", null, "MediterraneanDietFan");
                Comment newCommentother7 = new Comment(otherPost2, sqlTimestamp, "Nie ma nic lepszego niż praktyka języka z native speakerami.", null, "PracticeMakesPerfect");
                Comment newCommentother8 = new Comment(otherPost3, sqlTimestamp, "Ja lubię chodzić na długie spacery, żeby się zrelaksować.", null, "NatureLover");
                Comment newCommentother9 = new Comment(otherPost4, sqlTimestamp, "Zasada 'nie inwestuj więcej niż jesteś gotów stracić' jest szczególnie istotna w kontekście kryptowalut.", null, "InvestorAdvice");

                commentRepository.save(newCommentother5);
                commentRepository.save(newCommentother6);
                commentRepository.save(newCommentother7);
                commentRepository.save(newCommentother8);
                commentRepository.save(newCommentother9);

                Comment newCommentother10 = new Comment(otherPost, sqlTimestamp, "Jeśli lubisz kryminały, to polecam 'Millenium' Stiega Larssona.", null, "CrimeNovelAddict");
                Comment newCommentother11 = new Comment(otherPost1, sqlTimestamp, "Dieta wegańska ma wiele korzyści zdrowotnych, ale pamiętaj o odpowiednim bilansowaniu składników odżywczych.", null, "VeganLife");
                Comment newCommentother12 = new Comment(otherPost2, sqlTimestamp, "Konsekwencja to klucz do nauki języka. Regularnie poświęcaj czas na praktykę.", null, "LanguageTeacher");
                Comment newCommentother13 = new Comment(otherPost3, sqlTimestamp, "Joga i pilates to nie tylko ćwiczenia fizyczne, ale też świetny sposób na relaks.", null, "FitnessInstructor");
                Comment newCommentother14 = new Comment(otherPost4, sqlTimestamp, "Rozważ różne kryptowaluty. Bitcoin to nie jedyna opcja.", null, "CryptoDiversifier");

                Comment newCommentother15 = new Comment(otherPost, sqlTimestamp, "Ja uwielbiam biografie. Dają wiele inspiracji do życia.", null, "BiographyLover");
                Comment newCommentother16 = new Comment(otherPost1, sqlTimestamp, "Przejdź na dietę bogatą w warzywa i owoce. To zawsze dobra rada.", null, "Nutritionist");
                Comment newCommentother17 = new Comment(otherPost2, sqlTimestamp, "Pamiętaj, że każdy język ma swoją unikalną melodykę. Słuchaj native speakerów.", null, "Linguist");
                Comment newCommentother18 = new Comment(otherPost3, sqlTimestamp, "Muzyka to mój sposób na relaks. Zwłaszcza klasyczna.", null, "MusicLover");
                Comment newCommentother19 = new Comment(otherPost4, sqlTimestamp, "Nauka i zrozumienie technologii blockchain jest kluczem do sukcesu w inwestowaniu w kryptowaluty.", null, "BlockchainBeliever");

                commentRepository.save(newCommentother10);
                commentRepository.save(newCommentother11);
                commentRepository.save(newCommentother12);
                commentRepository.save(newCommentother13);
                commentRepository.save(newCommentother14);
                commentRepository.save(newCommentother15);
                commentRepository.save(newCommentother16);
                commentRepository.save(newCommentother17);
                commentRepository.save(newCommentother18);
                commentRepository.save(newCommentother19);

                Post mechanicPost = new Post(newCategory4, sqlTimestamp, "Jaka jest różnica między silnikiem diesla a benzynowym?", "Porównanie silników diesla i benzynowych");
                Post mechanicPost1 = new Post(newCategory4, sqlTimestamp, "Jakie są zalety i wady samochodów hybrydowych?", "Analiza samochodów hybrydowych");
                Post mechanicPost2 = new Post(newCategory4, sqlTimestamp, "Jakie są najlepsze techniki jazdy defensywnej?", "Poradnik jazdy defensywnej");
                Post mechanicPost3 = new Post(newCategory4, sqlTimestamp, "Jak często powinienem zmieniać olej w moim samochodzie?", "Konserwacja samochodów - olej silnikowy");
                Post mechanicPost4 = new Post(newCategory4, sqlTimestamp, "Czy warto inwestować w samochody elektryczne?", "Przegląd samochodów elektrycznych");

                postRepository.save(mechanicPost);
                postRepository.save(mechanicPost1);
                postRepository.save(mechanicPost2);
                postRepository.save(mechanicPost3);
                postRepository.save(mechanicPost4);

                Comment newCommentmechanic = new Comment(mechanicPost, sqlTimestamp, "Silniki Diesla są bardziej efektywne paliwowo, ale mniej przyjazne dla środowiska.", null, "CarExpert");
                Comment newCommentmechanic1 = new Comment(mechanicPost1, sqlTimestamp, "Hybrydy są świetne do jazdy w mieście, ale na długie trasy mogą nie być tak efektywne.", null, "HybridFan");
                Comment newCommentmechanic2 = new Comment(mechanicPost2, sqlTimestamp, "Zawsze trzymaj bezpieczny odstęp od innych pojazdów!", null, "SafeDriver");
                Comment newCommentmechanic3 = new Comment(mechanicPost3, sqlTimestamp, "Zależy od twojego samochodu, ale generalnie co 10 000 - 15 000 km.", null, "MechanicAdvice");
                Comment newCommentmechanic4 = new Comment(mechanicPost4, sqlTimestamp, "Elektryki mają dużą przyszłość, ale musisz uwzględnić koszty i dostępność stacji ładowania.", null, "EVAdvocate");

                commentRepository.save(newCommentmechanic);
                commentRepository.save(newCommentmechanic1);
                commentRepository.save(newCommentmechanic2);
                commentRepository.save(newCommentmechanic3);
                commentRepository.save(newCommentmechanic4);

                Comment newCommentmechanic5 = new Comment(mechanicPost, sqlTimestamp, "Silniki benzynowe są zazwyczaj cichsze i mają lepszą reakcję na przyspieszenie.", null, "GasolineFan");
                Comment newCommentmechanic6 = new Comment(mechanicPost1, sqlTimestamp, "Pamiętaj, że hybrydy są droższe w zakupie niż tradycyjne samochody.", null, "CostEffective");
                Comment newCommentmechanic7 = new Comment(mechanicPost2, sqlTimestamp, "Unikaj naglej zmiany pasa i zawsze używaj kierunkowskazów.", null, "DefensiveDriver");
                Comment newCommentmechanic8 = new Comment(mechanicPost3, sqlTimestamp, "Jeśli nie jesteś pewien, sprawdź instrukcję obsługi swojego samochodu.", null, "ManualReader");
                Comment newCommentmechanic9 = new Comment(mechanicPost4, sqlTimestamp, "Zwróć uwagę na zakres. Nie wszystkie samochody elektryczne mają taką samą zdolność do długodystansowej jazdy.", null, "RangeChecker");

                commentRepository.save(newCommentmechanic5);
                commentRepository.save(newCommentmechanic6);
                commentRepository.save(newCommentmechanic7);
                commentRepository.save(newCommentmechanic8);
                commentRepository.save(newCommentmechanic9);

                Comment newCommentmechanic10 = new Comment(mechanicPost, sqlTimestamp, "Silniki Diesla są bardziej wydajne w przypadku długich tras.", null, "DieselDriver");
                Comment newCommentmechanic11 = new Comment(mechanicPost1, sqlTimestamp, "Samochody hybrydowe są idealne do codziennych dojazdów do pracy.", null, "HybridUser");
                Comment newCommentmechanic12 = new Comment(mechanicPost2, sqlTimestamp, "Zawsze bądź świadomy swoich martwych punktów.", null, "DrivingInstructor");
                Comment newCommentmechanic13 = new Comment(mechanicPost3, sqlTimestamp, "Częstość zmiany oleju zależy też od warunków, w jakich jeździsz.", null, "ExperiencedMechanic");
                Comment newCommentmechanic14 = new Comment(mechanicPost4, sqlTimestamp, "Zdecydowanie tak, samochody elektryczne są przyszłością.", null, "GreenEnthusiast");

                Comment newCommentmechanic15 = new Comment(mechanicPost, sqlTimestamp, "Benzynowe silniki mają lepszą moc i przyspieszenie.", null, "Petrolhead");
                Comment newCommentmechanic16 = new Comment(mechanicPost1, sqlTimestamp, "Bardziej ekonomiczne, ale wymagają droższych napraw.", null, "CarMechanic");
                Comment newCommentmechanic17 = new Comment(mechanicPost2, sqlTimestamp, "Nie zapominaj o zasadzie '3 sekund' - to bezpieczny odstęp od auta przed tobą.", null, "SafetyFirst");
                Comment newCommentmechanic18 = new Comment(mechanicPost3, sqlTimestamp, "To jest ważne, aby utrzymać silnik w dobrej kondycji.", null, "EngineExpert");
                Comment newCommentmechanic19 = new Comment(mechanicPost4, sqlTimestamp, "Z punktu widzenia ekologii, warto zainwestować.", null, "EcoWarrior");

                Comment newCommentmechanic20 = new Comment(mechanicPost, sqlTimestamp, "Silniki Diesla są trudniejsze i droższe do naprawy.", null, "RepairShopOwner");
                Comment newCommentmechanic21 = new Comment(mechanicPost1, sqlTimestamp, "Hybrydowy układ napędowy jest znacznie cichszy.", null, "SilentRideLover");
                Comment newCommentmechanic22 = new Comment(mechanicPost2, sqlTimestamp, "Pamiętaj o regularnym sprawdzaniu lusterek!", null, "MirrorCheckAdvocate");
                Comment newCommentmechanic23 = new Comment(mechanicPost3, sqlTimestamp, "Jeśli olej jest czarny i lepki, to na pewno czas na zmianę.", null, "OilChangeReminder");
                Comment newCommentmechanic24 = new Comment(mechanicPost4, sqlTimestamp, "Pamiętaj o dopłatach rządowych na samochody elektryczne!", null, "GovernmentGrantInfo");

                commentRepository.save(newCommentmechanic10);
                commentRepository.save(newCommentmechanic11);
                commentRepository.save(newCommentmechanic12);
                commentRepository.save(newCommentmechanic13);
                commentRepository.save(newCommentmechanic14);
                commentRepository.save(newCommentmechanic15);
                commentRepository.save(newCommentmechanic16);
                commentRepository.save(newCommentmechanic17);
                commentRepository.save(newCommentmechanic18);
                commentRepository.save(newCommentmechanic19);
                commentRepository.save(newCommentmechanic20);
                commentRepository.save(newCommentmechanic21);
                commentRepository.save(newCommentmechanic22);
                commentRepository.save(newCommentmechanic23);
                commentRepository.save(newCommentmechanic24);

                Comment newCommentfishingP1 = new Comment(fishingPost, sqlTimestamp, "Spinning to świetny sposób na połow ryb drapieżnych.", null, "SpinningLover");
                Comment newCommentfishingP2 = new Comment(fishingPost1, sqlTimestamp, "Należy pamiętać o sezonach ochronnych i rozmiarach minimalnych ryb.", null, "ResponsibleFisher");
                Comment newCommentfishingP3 = new Comment(fishingPost2, sqlTimestamp, "Lubię wędkować na muchę w górskich potokach.", null, "FlyFishingExpert");
                Comment newCommentfishingP4 = new Comment(fishingPost3, sqlTimestamp, "Nie zapomnij o odpowiednim zabezpieczeniu przed słońcem i insektami.", null, "HealthFirst");
                Comment newCommentfishingP5 = new Comment(fishingPost4, sqlTimestamp, "Często można znaleźć dobre miejsca na połów na forach wędkarskich.", null, "FishingForumUser");
                
                Comment newCommentfishingP6 = new Comment(fishingPost, sqlTimestamp, "Także polecam wędkowanie z łodzi, to inna perspektywa.", null, "BoatFisher");
                Comment newCommentfishingP7 = new Comment(fishingPost1, sqlTimestamp, "I pamiętaj o licencji wędkarskiej!", null, "LawAbidingCitizen");
                Comment newCommentfishingP8 = new Comment(fishingPost2, sqlTimestamp, "Ja osobiście wędkuję na karpie, to taka moja specjalność.", null, "CarpFishingFan");
                Comment newCommentfishingP9 = new Comment(fishingPost3, sqlTimestamp, "Kluczowe jest też dobranie odpowiedniego sprzętu do warunków.", null, "GearGeek");
                Comment newCommentfishingP10 = new Comment(fishingPost4, sqlTimestamp, "Zawsze szukam nowych miejsc na wędkowanie, to część zabawy.", null, "Explorer");
                
                Comment newCommentfishingP11 = new Comment(fishingPost, sqlTimestamp, "Uwielbiam spędzać czas na łonie natury, a wędkowanie daje mi na to idealną okazję.", null, "NatureLover");
                Comment newCommentfishingP12 = new Comment(fishingPost1, sqlTimestamp, "Owszem, ważne jest, aby szanować przyrodę i dbać o nasze wody.", null, "EcoFisher");
                Comment newCommentfishingP13 = new Comment(fishingPost2, sqlTimestamp, "Cierpliwość to klucz do dobrego połowu.", null, "PatientFisher");
                Comment newCommentfishingP14 = new Comment(fishingPost3, sqlTimestamp, "Hydracja też jest bardzo ważna, zwłaszcza podczas długiego dnia na słońcu.", null, "HydrationReminder");
                Comment newCommentfishingP15 = new Comment(fishingPost4, sqlTimestamp, "Nie zapominaj o bezpieczeństwie, zwłaszcza kiedy wędkujesz samotnie.", null, "SafetyFirst");
                
                Comment newCommentfishingP16 = new Comment(fishingPost, sqlTimestamp, "Dobrze jest też nauczyć się różnych technik rzutu.", null, "CastingMaster");
                Comment newCommentfishingP17 = new Comment(fishingPost1, sqlTimestamp, "Nauka rozpoznawania różnych gatunków ryb też jest przydatna.", null, "FishIdentifier");
                Comment newCommentfishingP18 = new Comment(fishingPost2, sqlTimestamp, "Warto też pamiętać, że nie zawsze chodzi o złowienie największej ryby. Ważne jest doświadczenie.", null, "ExperienceValuer");
                Comment newCommentfishingP19 = new Comment(fishingPost3, sqlTimestamp, "Dobre jedzenie i picie to podstawa każdej wędkarskiej wyprawy.", null, "Foodie");
                Comment newCommentfishingP20 = new Comment(fishingPost4, sqlTimestamp, "Przy wyborze miejsca pamiętaj też o regulacjach dotyczących wędkowania w danym miejscu.", null, "RegulationReminder");
                
                commentRepository.save(newCommentfishingP1);
                commentRepository.save(newCommentfishingP2);
                commentRepository.save(newCommentfishingP3);
                commentRepository.save(newCommentfishingP4);
                commentRepository.save(newCommentfishingP5);
                commentRepository.save(newCommentfishingP6);
                commentRepository.save(newCommentfishingP7);
                commentRepository.save(newCommentfishingP8);
                commentRepository.save(newCommentfishingP9);
                commentRepository.save(newCommentfishingP10);
                commentRepository.save(newCommentfishingP11);
                commentRepository.save(newCommentfishingP12);
                commentRepository.save(newCommentfishingP13);
                commentRepository.save(newCommentfishingP14);
                commentRepository.save(newCommentfishingP15);
                commentRepository.save(newCommentfishingP16);
                commentRepository.save(newCommentfishingP17);
                commentRepository.save(newCommentfishingP18);
                commentRepository.save(newCommentfishingP19);
                commentRepository.save(newCommentfishingP20);

                Uzytkownik newUzytkownik1 = new Uzytkownik("admin",
                                "$2a$10$Wu6dMFBjiEscLeC6mN/sAemKfVum0BBpn0t6xQNcF1L91lqktHkia", "ADMIN"); // haslo 1234
                Uzytkownik newUzytkownik2 = new Uzytkownik("test",
                                "$2a$10$Wu6dMFBjiEscLeC6mN/sAemKfVum0BBpn0t6xQNcF1L91lqktHkia", "USER"); // haslo 1234
                uzytkownikRepository.save(newUzytkownik1);
                uzytkownikRepository.save(newUzytkownik2);

                // Robert Macłowicz poleca
                User nowyAdmin = new User("admin", "$2a$10$QVBrjqpJ9EetDoRT6Dpd7.8vanjfSrNUC2zGWtnu9bdC3BhBtpd/e",
                                true);
                userRepository.save(nowyAdmin);
                Authority noweAuthority = new Authority("admin", "ROLE_ADMIN");
                authorityRepository.save(noweAuthority);

        }

}
