package d3vel0pper.com.weatherman.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import d3vel0pper.com.weatherman.R;
import d3vel0pper.com.weatherman.common.HttpResponseTask;
import d3vel0pper.com.weatherman.common.WeatherData;
import d3vel0pper.com.weatherman.fragment.NavigationDrawerFragment;
import d3vel0pper.com.weatherman.fragment.SettingFragment;

//

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    /**
    * Used to store the last screen title. For use in {@link #restoreActionBar()}.
    */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));



    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        // update the main content by replacing fragments when ND Item selected
        switch(position){
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                        .commit();
                break;
            case 1:
                SettingFragment settingFragment = SettingFragment.newInstance("Setting");
                fragmentManager.beginTransaction()
                        .replace(R.id.container, settingFragment)
                        .commit();
                break;
            default:
                DialogFragment dialogFragment = new PlaceholderFragment.myDialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"NDdialog");
                //Toast.makeText(getBaseContext(),"OtherItemClicked!!",Toast.LENGTH_SHORT).show();
                break;
        }


    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle ="Main";
                break;
            case 2:
                mTitle = "Setting";
                break;
            case 3:
                mTitle = "";
                break;
        }
    }


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private static String dialogData;
        public void setDialogData(String string){
            dialogData = string;
        }

        private boolean flag = false;
        private LinearLayout parentLayout;
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            parentLayout = (LinearLayout)rootView.findViewById(R.id.parent);


            if(!flag){
                HttpResponseTask task = new HttpResponseTask((MainActivity)getActivity(),parentLayout,this);
                task.execute();
                flag = true;
            }

            Button detailBtn;
            detailBtn = (Button)rootView.findViewById(R.id.detailBtn);
            detailBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogFragment dialogFragment = new myDialogFragment();
                    dialogFragment.show(getFragmentManager(),"Detail");
                }
            });

            return rootView;
        }


        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));

        }

        @Override
        public void onDetach() {
            super.onDetach();
            flag = false;
        }

        private void setBorder(LinearLayout borderObj){
            /*
            write code to make borderline here
             */
        }

        /**
         * DialogFragment
         */

        public static class myDialogFragment extends DialogFragment {
            @Override
            public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup, Bundle bundle){
                super.onCreateView(inflater,viewGroup,bundle);
                //Inflating layout of dialog
                View view = inflater.inflate(R.layout.dialog_layout,null);
                //ValuePassing From HttpResponseTask
                TextView textView = (TextView)view.findViewById(R.id.dialogText);
                textView.setText(dialogData);
                return view;


            }

            @NonNull
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState){

                Dialog dialog = super.onCreateDialog(savedInstanceState);
                dialog.setTitle("Detail");

                return dialog;
            }
        }

    }

}
