package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileForm(state: ProfileUiState, viewModel: ProfileViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("My Profile", fontSize = 24.sp,
            fontWeight = FontWeight.Bold,)
        Spacer(modifier = Modifier.height(12.dp))
        
        OutlinedTextField(
            value = state.name,
            onValueChange = viewModel::onNameChange,
            label = { Text("Full name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = state.email,
            onValueChange = {viewModel.onEmailChange(it)},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = state.contactNumber,
            onValueChange = {viewModel.onContactNumberChange(it)},
            label = { Text("Contact number") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = state.address,
            onValueChange = {viewModel.onAddressChange(it)},
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = state.username,
            onValueChange = {viewModel.onUsernameChange(it)},
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Text("Skills", fontWeight = FontWeight.Bold)
        Row(verticalAlignment = Alignment.CenterVertically) {

            OutlinedTextField(
                value = state.newSkill,
                onValueChange = {viewModel.onNewSkillChange(it)},
                label = { Text("Add a Skill") },
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.padding(8.dp))
            Button(onClick = { viewModel.AddSkill() }) {
                Text("Add")
            }
        }

        state.skills.forEach { skill ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextText("• $skill", modifier = Modifier.weight(1f))
                Text("Remove")
            }
    }
}
    Spacer(Modifier.height(20.dp))
    Button(onClick = { viewModel.showPreview() },
        modifier = Modifier.fillMaxWidth()) {
        Text("Preview")
    }
}