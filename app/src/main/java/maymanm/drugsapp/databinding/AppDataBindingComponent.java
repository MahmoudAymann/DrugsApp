package maymanm.drugsapp.databinding;

public class AppDataBindingComponent implements androidx.databinding.DataBindingComponent {

    public RecyclerViewsBinding getRecyclerViewsBinding(){
        return new RecyclerViewsBinding();
    }
    public OtherViewsBinding getOtherViewsBinding(){ return new OtherViewsBinding(); }
}
