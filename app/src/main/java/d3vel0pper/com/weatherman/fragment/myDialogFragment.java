package d3vel0pper.com.weatherman.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import d3vel0pper.com.weatherman.R;

/**
 * Created by D3vel0pper on 2016/04/29.
 */
public class myDialogFragment extends DialogFragment {
    private String dialogData;

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

    public void setData(String data){
        dialogData = data;
    }

}
