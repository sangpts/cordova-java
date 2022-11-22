package vn.edu.greenwich.cw_1_sample.ui.resident;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import vn.edu.greenwich.cw_1_sample.R;
import vn.edu.greenwich.cw_1_sample.database.ResimaDAO;
import vn.edu.greenwich.cw_1_sample.models.Resident;

public class ResidentRegisterConfirmFragment extends DialogFragment {
    protected ResimaDAO _db;
    protected Resident _resident;
    protected Button fmResidentRegisterConfirmButtonConfirm, fmResidentRegisterConfirmButtonCancel;
    protected TextView fmResidentRegisterConfirmName, fmResidentRegisterConfirmStartDate, fmResidentRegisterConfirmOwner,fmResidentRegisterConfirmDestination,fmResidentRegisterConfirmDescription, fmResidentRegisterConfirmVehicle, fmResidentRegisterConfirmHotel, fmResidentRegisterConfirmPlace;

    public ResidentRegisterConfirmFragment() {
        _resident = new Resident();
    }

    public ResidentRegisterConfirmFragment(Resident resident) {
        _resident = resident;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        _db = new ResimaDAO(getContext());
    }

    @Override
    public void onResume() {
        super.onResume();

        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resident_register_confirm, container, false);

        String name = getString(R.string.error_no_info);
        String description = getString(R.string.error_no_info);
        String destination = getString(R.string.error_no_info);
        String vehicle = getString(R.string.error_no_info);
        String hotel = getString(R.string.error_no_info);
        String place = getString(R.string.error_no_info);
        String startDate = getString(R.string.error_no_info);
        String ownerType = getString(R.string.error_no_info);

        fmResidentRegisterConfirmName = view.findViewById(R.id.fmResidentRegisterConfirmName);
        fmResidentRegisterConfirmStartDate = view.findViewById(R.id.fmResidentRegisterConfirmStartDate);
        fmResidentRegisterConfirmOwner = view.findViewById(R.id.fmResidentRegisterConfirmOwner);
        fmResidentRegisterConfirmDescription = view.findViewById(R.id.fmResidentRegisterConfirmDescription);
        fmResidentRegisterConfirmDestination = view.findViewById(R.id.fmResidentRegisterConfirmDestination);
        fmResidentRegisterConfirmVehicle = view.findViewById(R.id.fmResidentRegisterConfirmVehicle);
        fmResidentRegisterConfirmHotel = view.findViewById(R.id.fmResidentRegisterConfirmHotel);
        fmResidentRegisterConfirmPlace = view.findViewById(R.id.fmResidentRegisterConfirmPlace);
        fmResidentRegisterConfirmButtonCancel = view.findViewById(R.id.fmResidentRegisterConfirmButtonCancel);
        fmResidentRegisterConfirmButtonConfirm = view.findViewById(R.id.fmResidentRegisterConfirmButtonConfirm);

        if (_resident.getOwner() != -1) {
            ownerType = _resident.getOwner() == 1 ? getString(R.string.label_owner) : getString(R.string.label_tenant);
        }

        if (_resident.getName() != null && !_resident.getName().trim().isEmpty()) {
            name = _resident.getName();
        }

        if (_resident.getStartDate() != null && !_resident.getStartDate().trim().isEmpty()) {
            startDate = _resident.getStartDate();
        }

        if (_resident.getDescription() != null && !_resident.getDescription().trim().isEmpty()) {
            description = _resident.getDescription();
        }

        if (_resident.getDestination() != null && !_resident.getDestination().trim().isEmpty()) {
            destination = _resident.getDestination();
        }
        if (_resident.getVehicle() != null && !_resident.getVehicle().trim().isEmpty()) {
            vehicle = _resident.getVehicle();
        }
        if (_resident.getHotel() != null && !_resident.getHotel().trim().isEmpty()) {
            hotel = _resident.getHotel();
        }
        if (_resident.getPlace() != null && !_resident.getPlace().trim().isEmpty()) {
            place = _resident.getPlace();
        }


        fmResidentRegisterConfirmName.setText(name);
        fmResidentRegisterConfirmStartDate.setText(startDate);
        fmResidentRegisterConfirmOwner.setText(ownerType);
        fmResidentRegisterConfirmDestination.setText(destination);
        fmResidentRegisterConfirmDescription.setText(description);
        fmResidentRegisterConfirmVehicle.setText(vehicle);
        fmResidentRegisterConfirmHotel.setText(hotel);
        fmResidentRegisterConfirmPlace.setText(place);

        fmResidentRegisterConfirmButtonCancel.setOnClickListener(v -> dismiss());
        fmResidentRegisterConfirmButtonConfirm.setOnClickListener(v -> confirm());

        return view;
    }

    protected void confirm() {
        long status = _db.insertResident(_resident);

        FragmentListener listener = (FragmentListener) getParentFragment();
        listener.sendFromResidentRegisterConfirmFragment(status);

        dismiss();
    }

    public interface FragmentListener {
        void sendFromResidentRegisterConfirmFragment(long status);
    }
}