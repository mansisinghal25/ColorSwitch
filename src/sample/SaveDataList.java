package ColourSwitchGame;

import java.util.ArrayList;

public class SaveDataList implements java.io.Serializable {

    //private static final long serialVersionUID = 42L;
    public ArrayList<SaveData> list_ofSavedGames;

    public SaveDataList()
    {
        list_ofSavedGames= new ArrayList<SaveData>(6);
    }
}