package testframe.managers;

import testframe.pages.CreateKomPage;
import testframe.pages.StartPage;

public class PageMan {

    private static PageMan pageManager;

    private StartPage startPage;

    private CreateKomPage createKomPage;

    private PageMan() {
    }

    public static PageMan getPageMan() {
        if (pageManager == null) {
            pageManager = new PageMan();
      }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public CreateKomPage getCreateKomPage() {
        if (createKomPage == null) {
            createKomPage = new CreateKomPage();
        }
        return createKomPage;
    }
}

